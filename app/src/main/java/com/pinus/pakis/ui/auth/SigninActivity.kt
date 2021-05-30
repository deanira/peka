package com.pinus.pakis.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pinus.pakis.databinding.ActivitySigninBinding
import com.pinus.pakis.ui.main.MainActivity

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
            isLoading(true)
            auth.signInWithEmailAndPassword(
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    isLoading(false)
                    user = auth.currentUser!!
                    if (user.displayName == null) {
                        val intent = Intent(this, SetNameActivity::class.java)
                        startActivity(intent)
                    } else {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }

                } else {
                    isLoading(false)
                    Snackbar.make(binding.root, "ERROR! ${it.exception}", Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun isLoading(state: Boolean) {
        if (state) {
            binding.btnMasuk.visibility = View.INVISIBLE
            binding.pbMasuk.visibility = View.VISIBLE
        } else {
            binding.btnMasuk.visibility = View.VISIBLE
            binding.pbMasuk.visibility = View.INVISIBLE
        }
    }
}