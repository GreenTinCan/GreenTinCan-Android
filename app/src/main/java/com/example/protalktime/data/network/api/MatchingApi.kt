package com.example.protalktime.data.network.api

import com.example.protalktime.data.model.meeting.MatchingCreateRequest
import com.example.protalktime.data.model.meeting.MatchingCreateResponse
import com.example.protalktime.data.model.meeting.MatchingListResponse
import com.example.protalktime.data.model.meeting.MyMatchingResponse
import com.example.protalktime.util.Constants
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface MatchingApi {

    @GET("gather/all")
    suspend fun getMatchingList(
        @Header("Authorization") authorization: String,
        @Query("bigLocation") bigLocation: String,
        @Query("smallLocation") smallLocation: String
    ): MatchingListResponse

    @POST("/gather")
    suspend fun requestMatchingCreation(
        @Header("Authorization") authorization: String,
        @Body requestBody: MatchingCreateRequest
        ): MatchingCreateResponse
    @GET("/gather/self")
    suspend fun getMyMatching(
        @Header("Authorization") authorization: String = Constants.userInfo.authorization,
    ): MyMatchingResponse
    @GET("/gather/proposal/join")
    suspend fun joinMeeting(
        @Header("gatherId") gatherId:Int,
    ): MyMatchingResponse

//    @GET("/member/firend")
//    suspend fun getMyMatchingList(
//        @Header("Authorization") authorization: String = Constants.userInfo.authorization,
//    ): MyMatchingResponse
}