package com.example.protalktime.data.repository.test.datasource

import com.example.protalktime.data.model.profile.MyProfileResponse
import com.example.protalktime.data.model.profile.ProfileResponse
import com.example.protalktime.data.model.test.GetTestResponse
import com.example.protalktime.data.network.api.TestApi
import com.example.protalktime.data.network.api.profile.ProfileApi

class MyPageDataSourceImpl(private val profileApi: ProfileApi): MyPageDataSource {

    override suspend fun getProfileResult(nickName: String): ProfileResponse {
        return profileApi.getProfile(nickName)
    }
    override suspend fun getMyProfileResult(): MyProfileResponse {
        return profileApi.getMyProfile()
    }
}