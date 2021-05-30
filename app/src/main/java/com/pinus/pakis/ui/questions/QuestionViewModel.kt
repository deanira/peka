package com.pinus.pakis.ui.questions

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pakis.pinus.core.domain.model.Questionnaire
import com.pakis.pinus.core.utils.DataQuestionnaire

class QuestionViewModel : ViewModel() {
    fun getQuestionnaire(): MutableLiveData<ArrayList<Questionnaire>> {
        Log.d("size pertanyaan", DataQuestionnaire.generateQuestionnaire().value?.size.toString())
        return DataQuestionnaire.generateQuestionnaire()
    }
}