package com.pinus.pakis.ui.account

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pinus.pakis.R
import com.pinus.pakis.databinding.ActivityAccountBinding

class Account : AppCompatActivity() {

    private lateinit var binding: ActivityAccountBinding
    private lateinit var user: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = Firebase.auth.currentUser!!
        supportActionBar?.hide()

        binding.etProfileEmailInput.setText(FirebaseAuth.getInstance().currentUser?.email.toString())

        binding.btnUbahPassword.setOnClickListener {
            if (binding.etProfileEmailInput.text.toString().trim() != FirebaseAuth.getInstance().currentUser?.email.toString()){
                changeEmail()
            }
            changePassword()
        }
    }

    private fun changePassword() {
        user.updatePassword(binding.etProfileNewPasswordInput.text.toString()).addOnCompleteListener {task ->
            if (task.isSuccessful) {
                Log.d("STATUS", "User password updated.")
                Toast.makeText(this, "User password updated.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun changeEmail() {
        user.updateEmail(binding.etProfileEmailInput.text.toString().trim()).addOnCompleteListener {task ->
            if (task.isSuccessful) {
                Log.d("STATUS", "User email updated.")
                Toast.makeText(this, "User email updated.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}