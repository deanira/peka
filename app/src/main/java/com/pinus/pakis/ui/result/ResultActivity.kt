package com.pinus.pakis.ui.result

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.pinus.pakis.R
import com.pinus.pakis.databinding.ActivityResultBinding
import com.pinus.pakis.ml.Model
import com.pinus.pakis.ui.gopremium.GoPremiumActivity
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.lang.StringBuilder
import java.math.BigDecimal

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        calculateResult()
        setupViews()
    }

    private fun setupViews() {
        binding.tvGoPremium.setOnClickListener {
            val intent = Intent(this, GoPremiumActivity::class.java)
            startActivity(intent)
        }
    }

    private fun calculateResult() {
        val model = Model.newInstance(this)
        val inputInt = intent.getIntArrayExtra("EXTRA_LIST")!!

        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 52), DataType.FLOAT32)
        inputFeature0.loadArray(inputInt)

        Log.d("shape ", inputFeature0.shape[0].toString())

        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer


        Log.d("hasil ", outputFeature0.floatArray.joinToString())

        val arrayHasil = outputFeature0.floatArray.joinToString().split(",").toTypedArray()
        val arrayString = listOf("Authoration", "Authorative", "Permissive")
        val arrayFloat = arrayHasil.map {
            it.toFloat()
        }

        val mappedResult = mapOf(
            arrayFloat[0] to arrayString[0],
            arrayFloat[1] to arrayString[1],
            arrayFloat[2] to arrayString[2]
        )

        val sortedResult = mappedResult.keys.sortedDescending()

        val result = mappedResult[sortedResult[0]]

        Log.d("max value is", result!!)
        model.close()

        binding.tvLabel1.text = mappedResult[sortedResult[0]]
        binding.tvLabel2.text = mappedResult[sortedResult[1]]
        binding.tvLabel3.text = mappedResult[sortedResult[2]]

        val firstResult = sortedResult[0] * 100
        val secondResult = sortedResult[1] * 100
        val thirdResult = sortedResult[2] * 100

        binding.rcpb1.progress = firstResult
        binding.rcpb2.progress = secondResult
        binding.rcpb3.progress = thirdResult

        binding.tvResult1.text = BigDecimal(firstResult.toString()).toPlainString()
        binding.tvResult2.text = BigDecimal(secondResult.toString()).toPlainString()
        binding.tvResult3.text = BigDecimal(thirdResult.toString()).toPlainString()

        binding.tvLabelResult.text =
            StringBuilder("Anda cenderung menerapkan pola asuh ${mappedResult[sortedResult[0]]}")

        when (mappedResult[sortedResult[0]]) {
            arrayString[0] -> {
                binding.tvDescription.text = getString(R.string.desc_authoration)
                binding.tvThreat.text = getString(R.string.threat_authoration)
            }
            arrayString[1] -> {
                binding.tvDescription.text = getString(R.string.desc_authorative)
                binding.tvThreat.text = getString(R.string.threat_authorative)
            }
            arrayString[2] -> {
                binding.tvDescription.text = getString(R.string.desc_permissive)
                binding.tvThreat.text = getString(R.string.threat_permissive)
            }
        }
    }
}