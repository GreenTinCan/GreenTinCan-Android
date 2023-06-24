package com.example.protalktime.data.model.meeting
import com.example.protalktime.data.model.common.Header
import com.google.gson.annotations.SerializedName


data class MatchingCreateResponse(
    @SerializedName("body")
    val body: MatchingCreateResponseBody,
    @SerializedName("header")
    val header: Header
)

data class MatchingCreateResponseBody(
    @SerializedName("bigLocation")
    val bigLocation: String,
    @SerializedName("gatherId")
    val gatherId: Int,
    @SerializedName("maxPrice")
    val maxPrice: Int,
    @SerializedName("meetTime")
    val meetTime: String,
    @SerializedName("memberId")
    val memberId: Int,
    @SerializedName("memberNickName")
    val memberNickName: String,
    @SerializedName("memberProfileUrl")
    val memberProfileUrl: String,
    @SerializedName("memberStudentNum")
    val memberStudentNum: Int,
    @SerializedName("script")
    val script: String,
    @SerializedName("smallLocation")
    val smallLocation: String,
    @SerializedName("wishFood")
    val wishFood: String,
    @SerializedName("wishStore")
    val wishStore: String
)