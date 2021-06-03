package com.pinus.pakis.ui.account

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pinus.pakis.databinding.ActivityAccountBinding

class Account : AppCompatActivity() {

    private lateinit var binding: ActivityAccountBinding
    private lateinit var user: FirebaseUser
    val email = FirebaseAuth.getInstance().currentUser?.email.toString()
    val nama = FirebaseAuth.getInstance().currentUser?.displayName.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

        user = Firebase.auth.currentUser!!

        binding.etProfileEmailInput.setText(email)
        binding.etProfileNameInput.setText(nama)

        namaListener()

        binding.btnUbahPassword.setOnClickListener {
            if (binding.etProfileNameInput.text.toString()
                    .trim() != nama
            ) {
                isLoading(true)
                changeName()
            }
            if (!binding.etProfileNewPasswordConfirmInput.text.isNullOrEmpty()) {
                isLoading(true)
                changePassword()
            }
        }
    }

    private fun namaListener() {
        binding.etProfileNameInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != nama) {
                    binding.btnUbahPassword.visibility = View.VISIBLE
                }
                if (s == nama) {
                    binding.btnUbahPassword.visibility = View.INVISIBLE
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    private fun changeName() {
        val profileUpdate = UserProfileChangeRequest.Builder()
            .setDisplayName(binding.etProfileNameInput.text.toString())
            .build()

        user.updateProfile(profileUpdate)
        isLoading(false)
        showToast()
    }

    private fun showToast() {
        Toast.makeText(this, "Update akun berhasil", Toast.LENGTH_SHORT).show()
    }

    private fun changePassword() {
        user.updatePassword(binding.etProfileNewPasswordInput.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("STATUS", "User password updated.")
                    Toast.makeText(this, "User password updated.", Toast.LENGTH_SHORT).show()
                }
            }
        isLoading(false)
        showToast()
    }

    private fun isLoading(state: Boolean) {
        if (state) {
            binding.pbUpdate.visibility = View.VISIBLE
        } else {
            binding.pbUpdate.visibility = View.INVISIBLE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}