package com.example.protalktime.data.repository.meeting

import com.example.protalktime.data.model.meeting.MatchingListResponse

interface MatchingRepository {

    suspend fun getMatchingList(authorization: String, bigLocation: String, smallLocation: String): MatchingListResponse
}