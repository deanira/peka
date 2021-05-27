package com.pinus.pakis.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pinus.pakis.databinding.ActivitySigninBinding
import com.pinus.pakis.ui.MainActivity

class SigninActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySigninBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser

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
                    user = auth.currentUser!!
                    if (user.displayName == null) {
                        val intent = Intent(this, SetNameActivity::class.java)
                        startActivity(intent)
                    } else {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }

                } else {
                    Snackbar.make(binding.root, "ERROR! ${it.exception}", Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}