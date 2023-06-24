package com.example.protalktime.data.repository.meeting

import com.example.protalktime.data.model.meeting.MatchingCreateRequest
import com.example.protalktime.data.model.meeting.MatchingCreateResponse
import com.example.protalktime.data.model.meeting.MatchingListResponse
import com.example.protalktime.data.repository.meeting.datasource.NotificationDataSource

class NotificationRepositoryImpl(private val dataSource: NotificationDataSource) : NotificationRepository {

    override suspend fun getNotification(
        authorization: String,
        gatherId: Int,
    ): MatchingListResponse {
        return dataSource.getNotification(authorization,gatherId)
    }

}