package com.example.protalktime.data.repository.meeting.datasource

import com.example.protalktime.data.model.meeting.MatchingCreateRequest
import com.example.protalktime.data.model.meeting.MatchingCreateResponse
import com.example.protalktime.data.model.meeting.MatchingListResponse

interface NotificationDataSource {
    suspend fun getNotification(authorization: String,  gatherId: Int,): MatchingListResponse
}