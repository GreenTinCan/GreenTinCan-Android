package com.example.protalktime.di

import com.example.protalktime.data.repository.test.datasource.MyPageDataSource
import com.example.protalktime.data.repository.test.datasource.MyPageDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<MyPageDataSource> { MyPageDataSourceImpl(get()) }
}