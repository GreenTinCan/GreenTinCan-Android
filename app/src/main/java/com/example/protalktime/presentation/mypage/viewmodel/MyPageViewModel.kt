package com.example.protalktime.presentation.mypage.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.protalktime.data.model.profile.MyProfileResponseResult
import com.example.protalktime.data.model.profile.ProfileResponseResult
import com.example.protalktime.data.repository.profile.MyPageRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class MyPageViewModel( private val myPageRepository: MyPageRepository) : ViewModel() {

    private val _profile: MutableLiveData<MyProfileResponseResult> =
        MutableLiveData<MyProfileResponseResult>()
    val profile: LiveData<MyProfileResponseResult>
        get() = _profile
    init {
        Log.d("hi","FDSFs")
    }

    fun getProfile() {
        viewModelScope.launch {
            try {
                val response = myPageRepository.getMyProfileResult()
                if (response.header.status == 200) {
                    _profile.value = response.body

                    Timber.d("해당 장소에 대한 정보를 불러왔습니다 : ${_profile.value}")
                } else {
                    Timber.d("해당 장소에 대한 정보를 불러오는 데 실패했습니다 : status(${response.header.status})")
                }
            } catch (e: Throwable) {
                Timber.d(e)
            }
        }
    }
}