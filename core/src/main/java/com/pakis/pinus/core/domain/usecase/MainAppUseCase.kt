package com.pakis.pinus.core.domain.usecase

import com.pakis.pinus.core.data.source.remote.network.ApiResponse
import com.pakis.pinus.core.data.source.remote.response.ArticleResponse
import com.pakis.pinus.core.data.source.remote.response.MotivationResponse
import kotlinx.coroutines.flow.Flow

interface MainAppUseCase {

    suspend fun getArticles(): Flow<ApiResponse<ArticleResponse>>

    suspend fun getMotivation(): Flow<ApiResponse<MotivationResponse>>

}