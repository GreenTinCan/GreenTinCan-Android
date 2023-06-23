package com.example.protalktime.data.repository.meeting.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.protalktime.data.model.meeting.MatchingListBody
import com.example.protalktime.data.repository.meeting.MatchingRepository
import com.example.protalktime.util.Event
import kotlinx.coroutines.launch
import timber.log.Timber

class MatchingViewModel(private val repository: MatchingRepository): ViewModel() {

    private val _matchingList: MutableLiveData<Event<List<MatchingListBody>>> = MutableLiveData<Event<List<MatchingListBody>>>()
    val matchingList: LiveData<Event<List<MatchingListBody>>>
        get() = _matchingList

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
}