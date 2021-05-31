package com.pinus.pakis.ui.result

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.pinus.pakis.R
import com.pinus.pakis.databinding.ActivityAccountBinding
import com.pinus.pakis.databinding.ActivityResultBinding
import com.pinus.pakis.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer


class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculateResult()
    }

    private fun calculateResult() {
        val model = Model.newInstance(this)
//        val inputInt = intent.getIntArrayExtra("EXTRA_LIST")!!
        val inputInt = arrayListOf(
            1,
            3,
            2,
            4,
            2,
            4,
            1,
            3,
            2,
            5,
            5,
            2,
            3,
            3,
            4,
            5,
            4,
            4,
            3,
            4,
            1,
            2,
            1,
            3,
            1,
            0,
            4,
            4,
            3,
            5,
            3,
            3,
            5,
            2,
            1,
            3,
            3,
            3,
            5,
            5,
            4,
            4,
            5,
            5,
            2,
            4,
            3,
            3,
            3,
            5,
            5,
            4
        ).toIntArray()

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

        binding.rcpb1.progress = sortedResult[0] * 100
        binding.rcpb2.progress = sortedResult[1] * 100
        binding.rcpb3.progress = sortedResult[2] * 100

        binding.tvResult1.text = (sortedResult[0] * 100).toString()
        binding.tvResult2.text = (sortedResult[1] * 100).toString()
        binding.tvResult3.text = (sortedResult[2] * 100).toString()

//        binding.tvDescription.text =
    }
}