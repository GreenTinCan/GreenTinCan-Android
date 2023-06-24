package com.example.protalktime.di

import com.example.protalktime.data.repository.meeting.MatchingRepository
import com.example.protalktime.data.repository.meeting.MatchingRepositoryImpl
import com.example.protalktime.data.repository.profile.MyPageRepository
import com.example.protalktime.data.repository.profile.MyPageRepositoryImpl
import com.example.protalktime.data.repository.meeting.NotificationRepository
import com.example.protalktime.data.repository.meeting.NotificationRepositoryImpl
import com.example.protalktime.data.repository.test.TestRepository
import com.example.protalktime.data.repository.test.TestRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<TestRepository> { TestRepositoryImpl(get()) }
    single<MatchingRepository> { MatchingRepositoryImpl(get()) }
    single<NotificationRepository> { NotificationRepositoryImpl(get()) }
    single<MyPageRepository> { MyPageRepositoryImpl(get())}
}