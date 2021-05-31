package com.pakis.pinus.core.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class ArticleResponseItem(
    val id: String,
    @SerializedName("article_url")
    val articleURL: String,
    val deskripsi: String,
    @SerializedName("foto_url")
    val fotoURL: String,
    val judul: String
)