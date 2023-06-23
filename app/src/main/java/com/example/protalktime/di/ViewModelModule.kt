package com.example.protalktime.di

import com.example.protalktime.data.repository.meeting.viewmodel.MatchingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel { MatchingViewModel(get()) }
}