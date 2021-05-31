package com.pakis.pinus.core.domain.usecase

import com.pakis.pinus.core.data.source.remote.network.ApiResponse
import com.pakis.pinus.core.data.source.remote.response.ArticleResponse
import com.pakis.pinus.core.data.source.remote.response.MotivationResponse
import com.pakis.pinus.core.data.source.remote.response.VideoResponse
import com.pakis.pinus.core.domain.repository.IMainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainAppInteractor @Inject constructor(
    private val repository: IMainRepository
) : MainAppUseCase {
    override suspend fun getArticles(): Flow<ApiResponse<ArticleResponse>> =
        repository.getArticles()


    override suspend fun getMotivation(): Flow<ApiResponse<MotivationResponse>> =
        repository.getMotivation()

    override suspend fun getVideos(): Flow<ApiResponse<VideoResponse>> =
        repository.getVideos()


}