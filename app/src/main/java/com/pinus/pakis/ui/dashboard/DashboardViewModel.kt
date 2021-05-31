package com.pinus.pakis.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pakis.pinus.core.data.source.remote.network.ApiResponse
import com.pakis.pinus.core.data.source.remote.response.ArticleResponse
import com.pakis.pinus.core.data.source.remote.response.MotivationResponse
import com.pakis.pinus.core.data.source.remote.response.VideoResponse
import com.pakis.pinus.core.domain.model.Article
import com.pakis.pinus.core.domain.model.Video
import com.pakis.pinus.core.domain.usecase.MainAppUseCase
import com.pakis.pinus.core.utils.DataDummy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val useCase: MainAppUseCase
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Discovery"
    }
    val text: LiveData<String> = _text

    val motivation = MutableLiveData<MotivationResponse>()

    fun getMotivation() {
        viewModelScope.launch {
            val collect = useCase.getMotivation()
            collect.collect {
                when (val apiResponse = it) {
                    is ApiResponse.Success -> {
                        motivation.postValue(apiResponse.data!!)
                    }
                }
            }
        }
    }

    fun getDummyArticles(): MutableLiveData<ArrayList<Article>> {
        return DataDummy.generateArticles()
    }

    fun getDummyVideos(): MutableLiveData<ArrayList<Video>> {
        return DataDummy.generateVideos()
    }

}