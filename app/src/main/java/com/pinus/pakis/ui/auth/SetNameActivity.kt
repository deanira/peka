package com.pinus.pakis.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pinus.pakis.databinding.ActivitySetNameBinding
import com.pinus.pakis.ui.main.MainActivity

class SetNameActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySetNameBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetNameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        auth = Firebase.auth
        user = auth.currentUser!!

        binding.tvNext.setOnClickListener {
            updateProfile()
        }
    }

    private fun updateProfile() {
        val profileUpdate = UserProfileChangeRequest.Builder()
            .setDisplayName(binding.etName.text.toString())
            .build()

        user.updateProfile(profileUpdate)

        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}