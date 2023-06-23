package com.example.protalktime.data.repository.test.datasource

import com.example.protalktime.data.model.profile.MyProfileResponse
import com.example.protalktime.data.model.profile.ProfileResponse

interface MyPageDataSource {

    suspend fun getProfileResult(nickName: String): ProfileResponse
    suspend fun getMyProfileResult(): MyProfileResponse
}