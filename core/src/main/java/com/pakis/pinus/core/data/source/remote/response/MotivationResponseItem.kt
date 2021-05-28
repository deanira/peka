package com.pakis.pinus.core.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class MotivationResponseItem(
    @SerializedName("id")
    val id: String,
    @SerializedName("item")
    val item: String
)