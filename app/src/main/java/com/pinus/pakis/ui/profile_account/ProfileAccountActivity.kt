package com.pinus.pakis.ui.profile_account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pinus.pakis.R

class ProfileAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_account)
        supportActionBar?.hide()
    }
}