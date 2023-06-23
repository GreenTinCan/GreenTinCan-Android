package com.example.protalktime.data.repository.meeting.datasource

import com.example.protalktime.data.model.meeting.MatchingCreateRequest
import com.example.protalktime.data.model.meeting.MatchingCreateResponse
import com.example.protalktime.data.model.meeting.MatchingListResponse

interface MatchingDataSource {
    suspend fun getMatchingList(authorization: String, bigLocation: String, smallLocation: String): MatchingListResponse
    suspend fun requestMatchingCreation(authorization: String, requestBody: MatchingCreateRequest): MatchingCreateResponse
}