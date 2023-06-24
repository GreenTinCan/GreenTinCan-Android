package com.example.protalktime.data.model.profile

import com.example.protalktime.data.model.common.Header
import com.google.gson.annotations.SerializedName

data class Waiting(
    @SerializedName("header")
    val header: Header,
    @SerializedName("body")
    val body: List<MyWaitingList>
)
data class MyWaitingList(
    @SerializedName("friendId")
    val friendId: Int,
    @SerializedName("friendNickName")
    val friendNickName: String,
    @SerializedName("friendProfileUrl")
    val friendProfileUrl: String
)