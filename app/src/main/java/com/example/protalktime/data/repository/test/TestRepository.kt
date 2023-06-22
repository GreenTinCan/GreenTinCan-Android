package com.example.protalktime.data.repository.test

import com.example.protalktime.data.model.test.GetTestResponse

interface TestRepository {

    suspend fun getTestResult(testNumber: Int): GetTestResponse
}