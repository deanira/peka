package com.pinus.pakis.ui.result

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.pinus.pakis.R
import com.pinus.pakis.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer


class ResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val model = Model.newInstance(this)

        val inputInt = intArrayOf(5,1,5,1,4,2,5,1,5,1,2,5,3,4,2,1,1,2,1,1,1,5,1,4,1,5,1,4,4,4,4,4,4,3,4,3,4,4,4,3,3,4,5,4,3,4,3,4,4,4,3,3)

        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1,52), DataType.FLOAT32)
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

        val map = arrayString.zip(arrayFloat).toList()

        val mappedResult = mapOf(
            arrayFloat[0] to arrayString[0],
            arrayFloat[1] to arrayString[1],
            arrayFloat[2] to arrayString[2]
        )

        val maxfirst = mappedResult.maxOf {
            it.key
        }
        val maxvalue =
 //       Log.d("max value is", maxfirst.)
        model.close()
    }
}