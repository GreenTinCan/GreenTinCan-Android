package com.example.protalktime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.protalktime.databinding.ActivityMainBinding
import com.example.protalktime.presentation.common.BaseActivity
import com.example.protalktime.presentation.common.WindowUtil.setNavigationBarColor

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setNavigationBarColor(R.color.white)
    }

}