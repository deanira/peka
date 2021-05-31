package com.pinus.pakis.ui.dashboard.article

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pakis.pinus.core.data.source.remote.network.ApiResponse
import com.pakis.pinus.core.data.source.remote.response.ArticleResponse
import com.pakis.pinus.core.domain.usecase.MainAppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val useCase: MainAppUseCase
) : ViewModel() {

    val articles = MutableLiveData<ArticleResponse>()

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
}