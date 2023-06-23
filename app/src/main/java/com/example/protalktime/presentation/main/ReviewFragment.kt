package com.example.protalktime.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.protalktime.R
import com.example.protalktime.databinding.FragmentReviewBinding
import com.example.protalktime.presentation.common.BaseFragment

class ReviewFragment : BaseFragment<FragmentReviewBinding>(R.layout.fragment_review) {

    private var goodClick = false
    private var badClick = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.llGoodContainer.setOnClickListener {
            setReviewText(binding.tvGood, true)
            setReviewText(binding.tvBad, false)
        }

        binding.llBadContainer.setOnClickListener {
            setReviewText(binding.tvBad, true)
            setReviewText(binding.tvGood, false)
        }

        binding.btnReviewDone.setOnClickListener {

        }
    }

    private fun setReviewText(textView: TextView, isFocused: Boolean) {
        if(isFocused) {
            textView.setTextColor(ContextCompat.getColor(requireActivity(), R.color.Primary_03))
        } else {
            textView.setTextColor(ContextCompat.getColor(requireActivity(), R.color.Base_05))
        }
    }
}