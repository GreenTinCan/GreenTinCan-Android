package com.example.protalktime.data.network.api

import com.example.protalktime.data.model.test.GetTestResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TestApi {

    @GET("test/{testnumber}")
    suspend fun testConnectServer(
        @Path("testnumber") testNumber: Int
    ) : GetTestResponse


}