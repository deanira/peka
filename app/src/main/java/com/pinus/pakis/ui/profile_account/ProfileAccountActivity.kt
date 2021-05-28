package com.pinus.pakis.ui.profile_account

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pinus.pakis.R

class ProfileAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_account)
        supportActionBar?.hide()
    }
}