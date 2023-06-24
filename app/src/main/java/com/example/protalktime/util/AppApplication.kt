package com.example.protalktime.util

import android.app.Application
import com.example.protalktime.di.dataSourceModule
import com.example.protalktime.di.networkModule
import com.example.protalktime.di.repositoryModule
import com.example.protalktime.di.viewModelModule
import org.koin.core.context.startKoin
import timber.log.Timber

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(networkModule, viewModelModule, repositoryModule, dataSourceModule)
        }

        setUpTimber()
    }

    private fun setUpTimber() {
        Timber.plant(Timber.DebugTree())
    }

}