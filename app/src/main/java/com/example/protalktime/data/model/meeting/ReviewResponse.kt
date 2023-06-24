package com.example.protalktime.data.model.meeting
import com.example.protalktime.data.model.common.Header
import com.google.gson.annotations.SerializedName


data class ReviewResponse(
    @SerializedName("body")
    val body: Boolean,
    @SerializedName("header")
    val header: Header
)