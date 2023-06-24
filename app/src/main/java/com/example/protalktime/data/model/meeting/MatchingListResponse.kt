package com.example.protalktime.data.model.meeting
import com.example.protalktime.data.model.common.Header
import com.google.gson.annotations.SerializedName


data class MatchingListResponse(
    @SerializedName("body")
    val body: List<MatchingListBody>,
    @SerializedName("header")
    val header: Header
)
data class MyMatchingResponse(
    @SerializedName("body")
    val body: MatchingListBody,
    @SerializedName("header")
    val header: Header
)
data class MatchingListBody(
    @SerializedName("memberGood")
    val memberGood: Int,
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
    @SerializedName("memberImageUrl")
    val memberImageUrl: String,
    @SerializedName("memberNickName")
    val memberNickName: String,
    @SerializedName("memberSex")
    val memberSex: String,
    @SerializedName("script")
    val script: String,
    @SerializedName("smallLocation")
    val smallLocation: String,
    @SerializedName("wishFood")
    val wishFood: String,
    @SerializedName("wishStore")
    val wishStore: String
)
