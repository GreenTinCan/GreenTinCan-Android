package com.example.protalktime.presentation.main

import android.os.Bundle
import android.view.View
import com.example.protalktime.R
import com.example.protalktime.databinding.FragmentMeetingMainBinding
import com.example.protalktime.presentation.common.BaseFragment
import com.example.protalktime.presentation.common.WindowUtil.setStatusBarColor

class MatchingMainFragment : BaseFragment<FragmentMeetingMainBinding>(R.layout.fragment_meeting_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setStatusBarColor(R.color.transparent)
    }

}