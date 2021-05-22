package com.pinus.pakis.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pinus.pakis.R

class GoPremiumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_go_premium)

        supportActionBar?.hide()
    }
}