package com.example.protalktime.presentation.sign

import android.os.Bundle
import android.view.View
import com.example.protalktime.R
import com.example.protalktime.databinding.FragmentSignInBinding
import com.example.protalktime.presentation.common.BaseFragment
import com.example.protalktime.presentation.common.NavigationUtil.navigate
import com.example.protalktime.presentation.common.NavigationUtil.navigateUp
import com.example.protalktime.util.Constants

class SignInFragment : BaseFragment<FragmentSignInBinding>(R.layout.fragment_sign_in) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            Constants.userInfo.authorization = binding.etId.text.toString()
            navigate(R.id.action_signInFragment_to_meetingMainFragment)
        }

        binding.tvSubSubtitle.setOnClickListener {
            navigate(R.id.action_signInFragment_to_reviewFragment)
        }

    }
}