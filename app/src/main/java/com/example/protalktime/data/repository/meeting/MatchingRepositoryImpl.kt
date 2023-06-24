package com.example.protalktime.data.repository.meeting

import com.example.protalktime.data.model.meeting.MatchingCreateRequest
import com.example.protalktime.data.model.meeting.MatchingCreateResponse
import com.example.protalktime.data.model.meeting.MatchingListResponse
import com.example.protalktime.data.model.meeting.ReviewRequest
import com.example.protalktime.data.model.meeting.ReviewResponse
import com.example.protalktime.data.repository.meeting.datasource.MatchingDataSource

class MatchingRepositoryImpl(private val dataSource: MatchingDataSource) : MatchingRepository {

    override suspend fun getMatchingList(
        authorization: String,
        bigLocation: String,
        smallLocation: String
    ): MatchingListResponse {
        return dataSource.getMatchingList(authorization, bigLocation, smallLocation)
    }

    override suspend fun requestMatchingCreation(
        authorization: String,
        requestBody: MatchingCreateRequest
    ): MatchingCreateResponse {
        return dataSource.requestMatchingCreation(authorization, requestBody)
    }

    override suspend fun requestReviewCreation(
        authorization: String,
        requestBody: ReviewRequest
    ): ReviewResponse {
        return dataSource.requestReviewCreation(authorization, requestBody)
    }
}