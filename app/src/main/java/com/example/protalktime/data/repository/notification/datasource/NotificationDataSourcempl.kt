package com.example.protalktime.data.repository.meeting.datasource

import com.example.protalktime.data.model.meeting.MatchingListResponse
import com.example.protalktime.data.network.api.NotificationApi

class NotificationDataSourceImpl(private val notificationApi: NotificationApi): NotificationDataSource {

    override suspend fun getNotification(authorization: String,  gatherId: Int,): MatchingListResponse{
        return notificationApi.getJoin(authorization, gatherId)
    }



}