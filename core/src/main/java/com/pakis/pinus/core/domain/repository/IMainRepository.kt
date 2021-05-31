package com.pakis.pinus.core.domain.repository

import com.pakis.pinus.core.data.source.remote.network.ApiResponse
import com.pakis.pinus.core.data.source.remote.response.ArticleResponse
import com.pakis.pinus.core.data.source.remote.response.MotivationResponse
import com.pakis.pinus.core.data.source.remote.response.VideoResponse
import kotlinx.coroutines.flow.Flow

interface IMainRepository {

    suspend fun getArticles(): Flow<ApiResponse<ArticleResponse>>

    suspend fun getMotivation(): Flow<ApiResponse<MotivationResponse>>

    suspend fun getVideos(): Flow<ApiResponse<VideoResponse>>

}