package com.pinus.pakis.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pinus.pakis.R
import com.pinus.pakis.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.Tensor
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer

class ResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val model = Model.newInstance(this)

        val inputInt = intArrayOf(1,4,2,4,2,5,1,4,5,5,4,3,4,4,4,5,5,5,5,4,3,3,3,3,4,4,3,3,4,3,3,3,4,3,4,3,4,3,4,3,3,4,1,2,3,2,3,4,3,2,2,1)
        val inputFeature0 = TensorBuffer.createFixedSize(inputInt, DataType.FLOAT32)
        val byteBuffer : ByteBuffer = ByteBuffer.allocate(52 )
        inputFeature0.loadBuffer(byteBuffer)

        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer

        Log.d("hasil ", outputFeature0.dataType.name)
        model.close()
    }
}