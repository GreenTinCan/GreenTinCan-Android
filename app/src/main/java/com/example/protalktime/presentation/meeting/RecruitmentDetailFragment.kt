package com.example.protalktime.presentation.meeting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.protalktime.R
import com.example.protalktime.databinding.FragmentRecruitmentDetailBinding
import com.example.protalktime.presentation.common.BaseFragment
import com.example.protalktime.presentation.common.WindowUtil.setNavigationBarColor

class RecruitmentDetailFragment : BaseFragment<FragmentRecruitmentDetailBinding>(R.layout.fragment_recruitment_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setNavigationBarColor(R.color.Base_08)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        setNavigationBarColor(R.color.white)
    }
}