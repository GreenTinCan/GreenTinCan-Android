package com.example.protalktime.di

import com.example.protalktime.presentation.community.viewmodel.CommunityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel { CommunityViewModel(get()) }
}