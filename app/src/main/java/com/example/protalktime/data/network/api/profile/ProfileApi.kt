package com.example.protalktime.data.network.api.profile

import com.example.protalktime.data.model.profile.MyProfileResponse
import com.example.protalktime.data.model.profile.MyProfileResponseResult
import com.example.protalktime.data.model.profile.ProfileResponse
import com.example.protalktime.data.model.test.GetTestResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ProfileApi {


    @GET("/member")
    suspend fun getProfile(
        @Header("Authorization") nickName: String
    ) : ProfileResponse

    @GET("/member/profile")
    suspend fun getMyProfile(
        @Header("Authorization") profileId: Int=1
    ) : MyProfileResponse

}