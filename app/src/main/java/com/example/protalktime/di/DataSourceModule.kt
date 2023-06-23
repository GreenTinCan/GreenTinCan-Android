package com.example.protalktime.di

import com.example.protalktime.data.repository.meeting.datasource.MatchingDataSource
import com.example.protalktime.data.repository.meeting.datasource.MatchingDataSourceImpl
import com.example.protalktime.data.repository.test.datasource.MyPageDataSource
import com.example.protalktime.data.repository.test.datasource.MyPageDataSourceImpl
import com.example.protalktime.data.repository.test.datasource.TestDataSource
import com.example.protalktime.data.repository.test.datasource.TestDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<TestDataSource> { TestDataSourceImpl(get()) }
    single<MatchingDataSource> { MatchingDataSourceImpl(get()) }
    single<MyPageDataSource> { MyPageDataSourceImpl(get()) }
}