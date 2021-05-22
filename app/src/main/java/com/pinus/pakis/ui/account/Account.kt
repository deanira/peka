package com.pinus.pakis.ui.account

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pinus.pakis.R

class Account : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        supportActionBar?.hide()
    }
}