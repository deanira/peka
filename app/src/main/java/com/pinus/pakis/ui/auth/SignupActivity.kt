package com.pinus.pakis.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pinus.pakis.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var auth: FirebaseAuth
    val TAG = SignupActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        auth = Firebase.auth

        binding.btnDaftar.setOnClickListener {
            isLoading(true)
            signUp()
        }

        binding.tvMasuk.setOnClickListener {
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signUp() {
        var isEmptyFields = false

        with(binding) {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            when {
                email.isEmpty() -> {
                    isEmptyFields = true
                    etEmail.error = "Field ini tidak boleh kosong"
                }
                password.isEmpty() -> {
                    isEmptyFields = true
                    etPassword.error = "Field ini tidak boleh kosong"
                }
            }

            if (!isEmptyFields) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this@SignupActivity) { task ->
                        if (task.isSuccessful) {
                            isLoading(false)
                            // Sign in success, update UI with the signed-in user's information
                            Snackbar.make(root, "Akun anda berhasil dibuat", Snackbar.LENGTH_SHORT)
                                .show()
                            Log.d(TAG, "createUserWithEmail:success")
                            val user = auth.currentUser

                            updateUI(user)
                            val intent = Intent(applicationContext, SigninActivity::class.java)
                            startActivity(intent)
                        } else {
                            isLoading(false)
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed. ${task.exception}",
                                Toast.LENGTH_LONG
                            ).show()
                            updateUI(null)
                        }
                    }
            }
        }
    }

    private fun isLoading(state: Boolean) {
        if (state) {
            binding.btnDaftar.visibility = View.INVISIBLE
            binding.pbDaftar.visibility = View.VISIBLE
        } else {
            binding.btnDaftar.visibility = View.VISIBLE
            binding.pbDaftar.visibility = View.INVISIBLE
        }
    }

    private fun updateUI(user: FirebaseUser?) {

    }
}