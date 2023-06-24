package com.example.protalktime.data.repository.test

import com.example.protalktime.data.model.test.GetTestResponse
import com.example.protalktime.data.repository.test.datasource.TestDataSource

class TestRepositoryImpl(private val testDataSource: TestDataSource): TestRepository {

    override suspend fun getTestResult(testNumber: Int): GetTestResponse {
        return testDataSource.getTestResult(testNumber)
    }

}