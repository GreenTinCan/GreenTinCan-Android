package com.example.protalktime.presentation.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.protalktime.R
import com.example.protalktime.databinding.FragmentCommunityMainBinding
import com.example.protalktime.presentation.common.BaseFragment
import com.example.protalktime.presentation.community.viewmodel.CommunityViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CommunityMainFragment : BaseFragment<FragmentCommunityMainBinding>(R.layout.fragment_community_main) {

    private val communityViewModel: CommunityViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnServerTest.setOnClickListener {
            communityViewModel.getServerTestResult(1)
        }

        communityViewModel.serverTestResponse.observe(viewLifecycleOwner) { testResponse ->
            binding.testResponse = testResponse
        }
    }

}