package com.example.protalktime.presentation.main

import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import com.example.protalktime.R
import com.example.protalktime.databinding.FragmentMatchingRequestBinding
import com.example.protalktime.presentation.common.BaseFragment
import com.example.protalktime.presentation.common.NavigationUtil.navigate
import com.example.protalktime.util.Constants
import com.google.android.material.chip.Chip

class MatchingRequestFragment : BaseFragment<FragmentMatchingRequestBinding>(R.layout.fragment_matching_request) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setNumberPickerInit(binding.npDay, 1, 31, 1)
        setNumberPickerInit(binding.npMonth, 1, 12, 1)
        setNumberPickerInit(binding.npHour, 0, 24, 0)
        setNumberPickerInit(binding.npMinute, 0, 60, 0)

        setThirdChipGroup("후생관")
        handleCategoryOptionEvent()

        binding.ivBackButton.setOnClickListener {
            navigate(R.id.action_matchingRequestFragment_to_meetingMainFragment)
        }
    }

    private fun handleCategoryOptionEvent() {
        binding.cgSecondRequest.setOnCheckedStateChangeListener { group, _ ->
            val checkedChip = getCheckedChip(group.checkedChipId)
            initCategoryOption(checkedChip)
        }
    }

    private fun getCheckedChip(checkedId: Int): Chip {
        return requireActivity().findViewById(checkedId) as Chip
    }

    private fun initCategoryOption(checkedChip: Chip) {
        val selectedCategoryOption = checkedChip.text.toString()
        setThirdChipGroup(selectedCategoryOption)
    }

    private fun setThirdChipGroup(selectedOption: String) {
        binding.cgThirdRequest.removeAllViews()
        var targetList = listOf<String>()
        when(selectedOption) {
            "후생관" -> {
                targetList = Constants.chipSetByWhoSaengGwan
            }
            "기숙사" -> {
                targetList = Constants.chipByDomitoryRoom
            }
            "어문관" -> {
                targetList = Constants.chipByMoonGwan
            }
        }
        for (category in targetList) {
            val chip: Chip = layoutInflater.inflate(
                R.layout.chip_gray_background,
                binding.cgThirdRequest,
                false
            ) as Chip
            binding.cgThirdRequest.addView(chip.apply {
                text = category
            })
        }
    }

    private fun setNumberPickerInit(v: NumberPicker, min: Int, max: Int, initValue: Int) {
        v.minValue = min
        v.maxValue = max
        v.value = initValue
    }
}