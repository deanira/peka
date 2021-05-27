package com.pinus.pakis.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.pinus.pakis.databinding.ActivitySignupBinding
import com.pinus.pakis.model.OrangTua


class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var ref: DatabaseReference
    var mFirebaseAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mFirebaseAuth = FirebaseAuth.getInstance()

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
                mFirebaseAuth!!.createUserWithEmailAndPassword(orangTua.email, orangTua.password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                applicationContext,
                                "Berhasil Membuat Akun",
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()
                            startActivity(Intent(this@SignupActivity,SigninActivity::class.java))
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Gagal Membuat Akun",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
            }
        }
    }
}