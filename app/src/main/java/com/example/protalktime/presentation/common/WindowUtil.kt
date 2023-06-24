package com.example.protalktime.presentation.common

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

object WindowUtil {

    // 상태 바, 네비게이션 바 관련
    fun Activity.setNavigationBarColor(navigationBarColor: Int) {
        window.navigationBarColor = ContextCompat.getColor(
            this, navigationBarColor
        )
    }

    fun Fragment.setNavigationBarColor(navigationBarColor: Int) {
        requireActivity().window.navigationBarColor = ContextCompat.getColor(
            requireActivity(), navigationBarColor
        )
    }

    fun Activity.setStatusBarColor(statusBarColor: Int) {
        window.statusBarColor = ContextCompat.getColor(
            this, statusBarColor
        )
    }

    fun Fragment.setStatusBarColor(statusBarColor: Int) {
        requireActivity().window.statusBarColor = ContextCompat.getColor(
            requireActivity(), statusBarColor
        )
    }

    fun setWindowColor(context: FragmentActivity, statusBarColor: Int, navigationBarColor: Int) {
        context.window.statusBarColor = ContextCompat.getColor(
            context,
            statusBarColor
        )

        context.window.navigationBarColor = ContextCompat.getColor(
            context, navigationBarColor
        )
    }

}