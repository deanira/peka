package com.pakis.pinus.core.data.source.remote

import com.pakis.pinus.core.data.source.remote.network.ApiResponse
import com.pakis.pinus.core.data.source.remote.network.ApiService
import com.pakis.pinus.core.data.source.remote.response.ArticleResponse
import com.pakis.pinus.core.data.source.remote.response.MotivationResponse
import com.pakis.pinus.core.data.source.remote.response.VideoResponse
import com.pakis.pinus.core.utils.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getMotivations(): Flow<ApiResponse<MotivationResponse>> {
        return flow {
            try {
                val response = apiService.getMotivations()
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
    suspend fun getArticles(): Flow<ApiResponse<ArticleResponse>> {
        return flow {
            try {
                val response = apiService.getArticles()
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getVideos() : Flow<ApiResponse<VideoResponse>>{
        return flow {
            try {
                val response = apiService.getVideos()
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}