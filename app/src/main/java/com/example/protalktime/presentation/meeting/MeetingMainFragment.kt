package com.example.protalktime.presentation.meeting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.protalktime.R
import com.example.protalktime.databinding.FragmentMeetingMainBinding
import com.example.protalktime.presentation.common.BaseFragment
import com.example.protalktime.presentation.common.NavigationUtil.navigate
import com.example.protalktime.presentation.common.WindowUtil.setNavigationBarColor
import com.example.protalktime.presentation.common.WindowUtil.setStatusBarColor

class MeetingMainFragment : BaseFragment<FragmentMeetingMainBinding>(R.layout.fragment_meeting_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setStatusBarColor(R.color.transparent)

        binding.fabCreateClub.setOnClickListener {
            navigate(R.id.action_nav_meeting_to_recruitmentDetailFragment)
        }

    }

}