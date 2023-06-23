package com.example.protalktime.data.network.api

import com.example.protalktime.data.model.meeting.MatchingListResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MatchingApi {

    @GET("gather/all")
    suspend fun getMatchingList(
        @Header("Authorization") authorization: String,
        @Query("bigLocation") bigLocation: String,
        @Query("smallLocation") smallLocation: String
    ): MatchingListResponse

}