package com.pinus.pakis.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.*
import com.pinus.pakis.databinding.ActivitySignupBinding
import com.pinus.pakis.model.OrangTua

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        ref = FirebaseDatabase.getInstance().getReference("orangtua")

        binding.btnDaftar.setOnClickListener {
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
            val nama = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            when {
                nama.isEmpty() -> {
                    isEmptyFields = true
                    etName.error = "Field ini tidak boleh kosong"
                }
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
                Log.d("halo", "tes firebase")
                val orangTuaId = ref.push().key
                val orangTua = OrangTua(orangTuaId!!, nama, email, password)

                ref.child(orangTuaId).setValue(orangTua).addOnCompleteListener {
                    Snackbar.make(root, "Akun anda berhasil dibuat", Snackbar.LENGTH_SHORT).show()

                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}