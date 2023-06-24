package com.example.protalktime.presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.protalktime.data.model.meeting.MatchingCreateRequest
import com.example.protalktime.data.model.meeting.MatchingCreateResponseBody
import com.example.protalktime.data.model.meeting.MatchingListBody
import com.example.protalktime.data.repository.meeting.MatchingRepository
import com.example.protalktime.data.repository.meeting.NotificationRepository
import com.example.protalktime.util.Event
import kotlinx.coroutines.launch
import timber.log.Timber

class MatchingViewModel(private val repository: MatchingRepository): ViewModel() {

    private val _matchingList: MutableLiveData<Event<List<MatchingListBody>>> = MutableLiveData<Event<List<MatchingListBody>>>()
    val matchingList: LiveData<Event<List<MatchingListBody>>>
        get() = _matchingList

    private val _myMatching: MutableLiveData<MatchingListBody> = MutableLiveData<MatchingListBody>()
    val myMatching: LiveData<MatchingListBody>
        get() = _myMatching
    private val _createMatchingResponse: MutableLiveData<Event<MatchingCreateResponseBody>> = MutableLiveData<Event<MatchingCreateResponseBody>>()
    val createMatchingResponse: LiveData<Event<MatchingCreateResponseBody>>
        get() = _createMatchingResponse

    fun getMatchingList(authorization: String, bigLocation: String, smallLocation: String) {
        viewModelScope.launch {
            try {
                val response = repository.getMatchingList(authorization, bigLocation, smallLocation)
                if(response.header.status == 200) {
                    _matchingList.value = Event(response.body)
                    Timber.d("Matching List 불러오기 성공 ${response.body}")
                }
            } catch (e: Throwable) {
                Timber.d("Matching List 불러오기 실패")
            }
        }
    }
    fun getMyMatchingList() {
        viewModelScope.launch {
            try {
                val response = repository.getMyMatching()
                if(response.header.status == 200) {
                    _myMatching.value = response.body
                    Timber.d("내 Matching  불러오기 성공 ${response.body}")
                }
            } catch (e: Throwable) {
                Timber.d("Matching List 불러오기 실패")
            }
        }
    }

    fun requestMatchingCreation(authorization: String, requestBody: MatchingCreateRequest) {
        viewModelScope.launch {
            try {
                val response = repository.requestMatchingCreation(authorization, requestBody)
                if(response.header.status == 200) {
                    _createMatchingResponse.value = Event(response.body)
                    Timber.d("매칭 생성 요청 성공 ${response.body}")
                }
            } catch (e: Throwable) {
                Timber.d("매칭 생성 요청 실패")
            }
        }
    }
}