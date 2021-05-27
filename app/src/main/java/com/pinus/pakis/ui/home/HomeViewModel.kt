package com.pinus.pakis.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Selamat pagi, ${FirebaseAuth.getInstance().currentUser?.displayName.toString()}"
    }
    val text: LiveData<String> = _text
}