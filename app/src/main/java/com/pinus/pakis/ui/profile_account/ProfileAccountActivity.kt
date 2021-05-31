package com.pinus.pakis.ui.profile_account

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.pinus.pakis.databinding.ActivityProfileAccountBinding

class ProfileAccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

        binding.tvNama.text = FirebaseAuth.getInstance().currentUser?.displayName.toString()
        binding.tvEmail.text = FirebaseAuth.getInstance().currentUser?.email.toString()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}