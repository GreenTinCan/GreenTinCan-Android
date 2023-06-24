package com.example.protalktime.data.model.test
import com.example.protalktime.data.model.common.Header
import com.google.gson.annotations.SerializedName

data class GetTestResponse(
    @SerializedName("body")
    val body: Int,
    @SerializedName("header")
    val header: Header
)