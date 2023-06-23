package com.example.protalktime.di

import com.example.protalktime.presentation.main.viewmodel.MatchingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel { MatchingViewModel(get()) }
}