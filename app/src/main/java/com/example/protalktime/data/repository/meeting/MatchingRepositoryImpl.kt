package com.example.protalktime.data.repository.meeting

import com.example.protalktime.data.model.meeting.MatchingCreateRequest
import com.example.protalktime.data.model.meeting.MatchingCreateResponse
import com.example.protalktime.data.model.meeting.MatchingListResponse
import com.example.protalktime.data.model.meeting.MyMatchingResponse
import com.example.protalktime.data.repository.meeting.datasource.MatchingDataSource
import com.example.protalktime.data.repository.meeting.datasource.NotificationDataSource

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
    override suspend fun getMyMatching(): MyMatchingResponse {
        return dataSource.getMyMatching()
    }
    override suspend fun joinMeeting(gatherId:Int):MyMatchingResponse{
        return dataSource.joinMeeting(gatherId)
    }
}