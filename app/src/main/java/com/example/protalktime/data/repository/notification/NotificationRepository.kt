package com.example.protalktime.data.repository.meeting

import com.example.protalktime.data.model.meeting.MatchingCreateRequest
import com.example.protalktime.data.model.meeting.MatchingCreateResponse
import com.example.protalktime.data.model.meeting.MatchingListResponse

interface NotificationRepository {
    suspend fun getNotification(
        authorization: String,
        gatherId: Int,
    ): MatchingListResponse
}