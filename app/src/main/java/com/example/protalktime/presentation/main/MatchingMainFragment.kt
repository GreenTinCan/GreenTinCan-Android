package com.example.protalktime.presentation.main

import android.os.Bundle
import android.view.View
import com.example.protalktime.R
import com.example.protalktime.data.repository.meeting.viewmodel.MatchingViewModel
import com.example.protalktime.databinding.FragmentMeetingMainBinding
import com.example.protalktime.presentation.common.BaseFragment
import com.example.protalktime.presentation.common.NavigationUtil.navigate
import com.example.protalktime.presentation.common.WindowUtil.setStatusBarColor
import com.example.protalktime.presentation.main.adapter.MatchingListAdapter
import com.example.protalktime.util.Constants
import com.example.protalktime.util.EventObserver
import com.google.android.material.chip.Chip
import com.google.android.material.tabs.TabLayout
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber

class MatchingMainFragment : BaseFragment<FragmentMeetingMainBinding>(R.layout.fragment_meeting_main) {

    private val matchingViewModel: MatchingViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setStatusBarColor(R.color.transparent)

        setChipGroup("교내")
        handleSelectedLocationOption()

        matchingViewModel.getMatchingList(Constants.userInfo.authorization, "교내", "후생관")

        binding.fabCreateClub.setOnClickListener {
            navigate(R.id.action_meetingMainFragment_to_matchingRequestFragment)
        }

        binding.rvMatching.adapter = MatchingListAdapter().apply {
            matchingViewModel.matchingList.observe(viewLifecycleOwner, EventObserver { matchingList ->
                submitList(matchingList)
            })
        }
    }

    private fun handleSelectedLocationOption() {
        binding.tlOptionLocation.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Timber.d("선택된 지역 옵션 : ${tab?.text}")
                setChipGroup(tab?.text.toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun setChipGroup(selectedLocation: String) {
        binding.cgSearchCategoryGroup.removeAllViews()
        var targetList = listOf<String>()
        when (selectedLocation) {
            "교내" -> {
                targetList = Constants.chipSetByInUniversity
            }

            "교외" -> {
                targetList = Constants.chipSetByOutside
            }
        }

        for (category in targetList) {
            val chip: Chip = layoutInflater.inflate(
                R.layout.chip_gray_background,
                binding.cgSearchCategoryGroup,
                false
            ) as Chip
            binding.cgSearchCategoryGroup.addView(chip.apply {
                text = category
                if(category == "후생관") {
                    isChecked = true
                }
            })
        }
    }
}