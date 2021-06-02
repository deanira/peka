package com.pinus.pakis.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.pakis.pinus.core.data.source.remote.network.ApiResponse
import com.pakis.pinus.core.data.source.remote.response.MotivationResponse
import com.pakis.pinus.core.domain.usecase.MainAppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: MainAppUseCase
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Selamat pagi, ${FirebaseAuth.getInstance().currentUser?.displayName.toString()}"
    }
    val text: LiveData<String> = _text

    val motivation = MutableLiveData<MotivationResponse>()

    fun getRandomMotivation() {
        viewModelScope.launch {
            val data = useCase.getMotivation()
            data.collect {
                when (it) {
                    is ApiResponse.Success -> {
                        motivation.postValue(it.data!!)
                    }
                }
            }
        }

    }
}