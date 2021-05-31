package com.pakis.pinus.core.data.source.remote

import com.pakis.pinus.core.data.source.remote.network.ApiResponse
import com.pakis.pinus.core.data.source.remote.response.ArticleResponse
import com.pakis.pinus.core.data.source.remote.response.MotivationResponse
import com.pakis.pinus.core.data.source.remote.response.VideoResponse
import com.pakis.pinus.core.domain.repository.IMainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : IMainRepository {

    override suspend fun getArticles() : Flow<ApiResponse<ArticleResponse>>{
        return remoteDataSource.getArticles()
    }

    override suspend fun getMotivation(): Flow<ApiResponse<MotivationResponse>> {
        return remoteDataSource.getMotivations()
    }

    override suspend fun getVideos(): Flow<ApiResponse<VideoResponse>> {
        return remoteDataSource.getVideos()
    }
}