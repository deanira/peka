package com.pakis.pinus.core.data.source.remote.network

import com.pakis.pinus.core.data.source.remote.response.ArticleResponse
import com.pakis.pinus.core.data.source.remote.response.MotivationResponse
import com.pakis.pinus.core.data.source.remote.response.VideoResponse
import retrofit2.http.GET

interface ApiService {

    @GET("motivation")
    suspend fun getMotivations() : MotivationResponse

    @GET("articles")
    suspend fun getArticles() : ArticleResponse

    @GET("videos")
    suspend fun getVideos() : VideoResponse
}