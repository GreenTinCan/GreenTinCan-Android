package com.example.protalktime.data.repository.profile

import com.example.protalktime.data.model.profile.MyProfileResponse
import com.example.protalktime.data.model.profile.ProfileResponse
import com.example.protalktime.data.repository.test.datasource.MyPageDataSource

class MyPageRepositoryImpl(private val myPageDataSource: MyPageDataSource): MyPageRepository {

    override suspend fun getProfileResult(nickName: String): ProfileResponse {
        return myPageDataSource.getProfileResult(nickName)
    }
    override suspend fun getMyProfileResult(): MyProfileResponse {
        return myPageDataSource.getMyProfileResult()
    }
}