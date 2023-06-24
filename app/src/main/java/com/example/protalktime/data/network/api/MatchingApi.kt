package com.example.protalktime.data.network.api

import com.example.protalktime.data.model.meeting.MatchingCreateRequest
import com.example.protalktime.data.model.meeting.MatchingCreateResponse
import com.example.protalktime.data.model.meeting.MatchingListResponse
import com.example.protalktime.data.model.meeting.ReviewRequest
import com.example.protalktime.data.model.meeting.ReviewResponse
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

    @POST("member/review")
    suspend fun requestReviewCreation(
        @Header("Authorization") authorization: String,
        @Body requestBody: ReviewRequest
        ): ReviewResponse

}