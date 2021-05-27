package com.pinus.pakis.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pinus.pakis.databinding.ActivitySigninBinding

class SigninActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySigninBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        supportActionBar?.hide()

        binding.btnMasuk.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    Snackbar.make(binding.root, "Anda berhasil login", Snackbar.LENGTH_SHORT)
                        .show()
                    val intent = Intent(this, SetNameActivity::class.java)
                    startActivity(intent)
                } else {
                    Snackbar.make(binding.root, "ERROR! ${it.exception}", Snackbar.LENGTH_SHORT)
                            .show()
                }
            }
        }
    }
}