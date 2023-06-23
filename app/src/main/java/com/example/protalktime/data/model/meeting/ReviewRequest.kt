package com.example.protalktime.data.model.meeting
import com.google.gson.annotations.SerializedName


data class ReviewRequest(
    @SerializedName("good")
    val good: Int,
    @SerializedName("bad")
    val bad: Int,
    @SerializedName("goodTime")
    val goodTime: Int,
    @SerializedName("badTime")
    val badTime: Int,
    @SerializedName("goodTaste")
    val goodTaste: Int,
    @SerializedName("badTaste")
    val badTaste: Int,
    @SerializedName("funny")
    val funny: Int,
)