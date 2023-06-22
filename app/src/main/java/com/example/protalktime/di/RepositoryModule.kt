package com.example.protalktime.di

import com.example.protalktime.data.repository.test.TestRepository
import com.example.protalktime.data.repository.test.TestRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<TestRepository> { TestRepositoryImpl(get()) }
}