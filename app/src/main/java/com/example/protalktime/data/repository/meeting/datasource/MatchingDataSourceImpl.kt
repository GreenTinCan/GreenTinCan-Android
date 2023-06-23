package com.example.protalktime.data.repository.meeting.datasource

import com.example.protalktime.data.model.meeting.MatchingListResponse
import com.example.protalktime.data.network.api.MatchingApi

class MatchingDataSourceImpl(private val matchingApi: MatchingApi): MatchingDataSource {

    override suspend fun getMatchingList(
        authorization: String,
        bigLocation: String,
        smallLocation: String
    ): MatchingListResponse {
        return matchingApi.getMatchingList(authorization, bigLocation, smallLocation)
    }
}