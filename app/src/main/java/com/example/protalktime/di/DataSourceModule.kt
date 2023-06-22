package com.example.protalktime.di

import com.example.protalktime.data.repository.test.datasource.TestDataSource
import com.example.protalktime.data.repository.test.datasource.TestDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<TestDataSource> { TestDataSourceImpl(get()) }
}