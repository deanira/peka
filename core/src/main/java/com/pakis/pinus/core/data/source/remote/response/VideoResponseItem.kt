package com.pakis.pinus.core.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class VideoResponseItem(
    @SerializedName("id")
    val id: String,
    @SerializedName("judul")
    val judul: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("video_url")
    val videoUrl: String
)