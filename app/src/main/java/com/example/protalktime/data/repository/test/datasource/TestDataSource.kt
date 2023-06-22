package com.example.protalktime.data.repository.test.datasource

import com.example.protalktime.data.model.test.GetTestResponse

interface TestDataSource {

    suspend fun getTestResult(testNumber: Int): GetTestResponse
}