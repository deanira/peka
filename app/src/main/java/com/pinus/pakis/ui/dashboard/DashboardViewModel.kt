package com.pinus.pakis.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pakis.pinus.core.data.source.remote.network.ApiResponse
import com.pakis.pinus.core.data.source.remote.response.ArticleResponse
import com.pakis.pinus.core.data.source.remote.response.MotivationResponse
import com.pakis.pinus.core.domain.usecase.MainAppUseCase
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

    val articles = MutableLiveData<ArticleResponse>()
    val motivation = MutableLiveData<MotivationResponse>()

    fun getArticles() {
        viewModelScope.launch {
            val collect = useCase.getArticles()
            collect.collect {
                when (val apiResponse = it) {
                    is ApiResponse.Success -> {
                        articles.postValue(apiResponse.data!!)
                    }
                }
            }
        }
    }
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

}