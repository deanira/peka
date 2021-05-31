package com.pinus.pakis.ui.dashboard.video

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pakis.pinus.core.data.source.remote.network.ApiResponse
import com.pakis.pinus.core.data.source.remote.response.VideoResponse
import com.pakis.pinus.core.domain.usecase.MainAppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val useCase: MainAppUseCase
) : ViewModel() {

    val videos = MutableLiveData<VideoResponse>()

    fun getVideos() {
        viewModelScope.launch {
            val collect = useCase.getVideos()
            collect.collect {
                when(val apiResponse = it){
                    is ApiResponse.Success -> {
                        videos.postValue(apiResponse.data!!)
                    }
                }
            }
        }
    }
}