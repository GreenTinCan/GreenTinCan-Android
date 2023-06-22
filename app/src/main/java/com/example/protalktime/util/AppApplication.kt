package com.example.protalktime.util

import android.app.Application
import timber.log.Timber

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        setUpTimber()
    }

    private fun setUpTimber() {
        Timber.plant(Timber.DebugTree())
    }

}