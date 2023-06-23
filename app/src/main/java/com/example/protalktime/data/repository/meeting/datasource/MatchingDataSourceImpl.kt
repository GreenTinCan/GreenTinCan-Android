package com.example.protalktime.data.repository.meeting.datasource

import com.example.protalktime.data.model.meeting.MatchingCreateRequest
import com.example.protalktime.data.model.meeting.MatchingCreateResponse
import com.example.protalktime.data.model.meeting.MatchingListResponse
import com.example.protalktime.data.model.meeting.ReviewRequest
import com.example.protalktime.data.model.meeting.ReviewResponse
import com.example.protalktime.data.network.api.MatchingApi

class MatchingDataSourceImpl(private val matchingApi: MatchingApi): MatchingDataSource {

    override suspend fun getMatchingList(
        authorization: String,
        bigLocation: String,
        smallLocation: String
    ): MatchingListResponse {
        return matchingApi.getMatchingList(authorization, bigLocation, smallLocation)
    }

    override suspend fun requestMatchingCreation(
        authorization: String,
        requestBody: MatchingCreateRequest
    ): MatchingCreateResponse {
        return matchingApi.requestMatchingCreation(authorization, requestBody)
    }

    override suspend fun requestReviewCreation(
        authorization: String,
        requestBody: ReviewRequest
    ): ReviewResponse {
        return matchingApi.requestReviewCreation(authorization, requestBody)
    }
}