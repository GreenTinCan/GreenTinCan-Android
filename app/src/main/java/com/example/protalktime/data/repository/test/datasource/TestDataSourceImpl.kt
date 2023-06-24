package com.example.protalktime.data.repository.test.datasource

import com.example.protalktime.data.model.test.GetTestResponse
import com.example.protalktime.data.network.api.TestApi

class TestDataSourceImpl(private val testApi: TestApi): TestDataSource {

    override suspend fun getTestResult(testNumber: Int): GetTestResponse {
        return testApi.testConnectServer(testNumber)
    }
}