package com.pinus.pakis.ui.dashboard.conseling

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pakis.pinus.core.data.source.remote.response.ArticleResponse
import com.pakis.pinus.core.domain.usecase.MainAppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConselingViewModel   @Inject constructor(
    private val useCase: MainAppUseCase
) : ViewModel() {
}