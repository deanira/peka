package com.pinus.pakis.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pinus.pakis.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvPakis.alpha = 0f
        binding.tvSubtitle.alpha = 0f
        binding.tvSubtitle.animate().setDuration(3000).alpha(1f)
        binding.tvPakis.animate().setDuration(3000).alpha(1f).withEndAction {
            val Intent = Intent(this, IntroductoryActivity::class.java)
            startActivity(Intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }



        supportActionBar?.hide()
    }
}