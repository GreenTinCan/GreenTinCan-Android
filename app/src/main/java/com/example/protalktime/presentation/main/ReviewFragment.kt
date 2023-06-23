package com.example.protalktime.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.protalktime.R
import com.example.protalktime.data.model.meeting.ReviewRequest
import com.example.protalktime.databinding.FragmentReviewBinding
import com.example.protalktime.presentation.common.BaseFragment
import com.example.protalktime.presentation.common.CustomSnackBar
import com.example.protalktime.presentation.common.NavigationUtil.navigate
import com.example.protalktime.presentation.common.NavigationUtil.navigateUp
import com.example.protalktime.presentation.main.viewmodel.MatchingViewModel
import com.example.protalktime.util.Constants
import com.example.protalktime.util.EventObserver
import com.google.android.material.chip.Chip
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ReviewFragment : BaseFragment<FragmentReviewBinding>(R.layout.fragment_review) {

    private val matchingViewModel: MatchingViewModel by sharedViewModel()

    private var goodClick = false
    private var badClick = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.llGoodContainer.setOnClickListener {
            setReviewText(binding.tvGood, true)
            setReviewText(binding.tvBad, false)
            goodClick = true
            badClick = false
        }

        binding.llBadContainer.setOnClickListener {
            setReviewText(binding.tvBad, true)
            setReviewText(binding.tvGood, false)
            badClick = true
            goodClick = false
        }

        binding.btnReviewDone.setOnClickListener {
            var good = 0
            var bad = 0

            if(goodClick) {
                good = 1
                bad = 0
            } else {
                good = 0
                bad = 1
            }
            val requestBody = ReviewRequest(
                good,
                bad,
                getCheckedChip(binding.cGoodTime),
                getCheckedChip(binding.cBadTime),
                getCheckedChip(binding.cGoodTaste),
                getCheckedChip(binding.cBadTaste),
                getCheckedChip(binding.cGoodChat)
            )
            matchingViewModel.requestReviewCreation(Constants.userInfo.authorization, requestBody)
            val drawable = ContextCompat.getDrawable(requireActivity(), R.drawable.ic_caution_30)!!
            CustomSnackBar.make(binding.root, "다시 시도해 주세요", drawable).show()
        }

        matchingViewModel.createReviewResponse.observe(viewLifecycleOwner, EventObserver {isSuccess ->
            if(isSuccess) {
                val drawable = ContextCompat.getDrawable(requireActivity(), R.drawable.ic_check_30)!!
                CustomSnackBar.make(binding.root, "후기가 등록됐어요", drawable).show()
                navigate(R.id.action_reviewFragment_to_meetingMainFragment)
            } else {
                val drawable = ContextCompat.getDrawable(requireActivity(), R.drawable.ic_caution_30)!!
                CustomSnackBar.make(binding.root, "다시 시도해 주세요", drawable).show()
            }
        })
    }

    private fun setReviewText(textView: TextView, isFocused: Boolean) {
        if(isFocused) {
            textView.setTextColor(ContextCompat.getColor(requireActivity(), R.color.Primary_03))
        } else {
            textView.setTextColor(ContextCompat.getColor(requireActivity(), R.color.Base_05))
        }
    }

    private fun getCheckedChip(chip: Chip): Int {
        return if(chip.isChecked) 1
        else 0
    }
}