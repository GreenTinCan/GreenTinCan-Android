package com.example.protalktime.data.network.api

import com.example.protalktime.data.model.meeting.MatchingListResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface NotificationApi {
    @GET("/gather/proposal/join")
    suspend fun getJoin(
        @Header("Authorization") authorization: String,
        @Path("gatherId") gatherId: Int,
    ): MatchingListResponse

}