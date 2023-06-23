package com.example.protalktime.data.repository.profile

import com.example.protalktime.data.model.profile.MyProfileResponse
import com.example.protalktime.data.model.profile.ProfileResponse

interface MyPageRepository{

    suspend fun getProfileResult(nickName: String): ProfileResponse
    suspend fun getMyProfileResult(): MyProfileResponse
}