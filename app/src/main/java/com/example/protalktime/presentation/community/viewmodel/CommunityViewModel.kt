package com.example.protalktime.presentation.community.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.protalktime.data.model.test.GetTestResponse
import com.example.protalktime.data.repository.test.TestRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class CommunityViewModel(private val repository: TestRepository): ViewModel() {

    private val _serverTestResponse: MutableLiveData<GetTestResponse> = MutableLiveData<GetTestResponse>()
    val serverTestResponse: LiveData<GetTestResponse>
        get() = _serverTestResponse

    fun getServerTestResult(testNumber: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getTestResult(testNumber)
                if(response.header.status == 200) {
                    _serverTestResponse.value = response
                    Timber.d("Test Success!")
                } else {
                    Timber.d("Test Error : ${response.header.status}")
                }
            } catch (e: Throwable) {
                Timber.d(e)
            }
        }
    }
}