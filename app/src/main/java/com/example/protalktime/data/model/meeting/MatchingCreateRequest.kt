package com.example.protalktime.data.model.meeting
import com.google.gson.annotations.SerializedName

data class MatchingCreateRequest(
    @SerializedName("bigLocation")
    val bigLocation: String,
    @SerializedName("smallLocation")
    val smallLocation: String,
    @SerializedName("wishStore")
    val wishStore: String,
    @SerializedName("wishFood")
    val wishFood: String,
    @SerializedName("meetTime")
    val meetTime: String,
    @SerializedName("maxPrice")
    val maxPrice: Int,
    @SerializedName("script")
    val script: String,
)