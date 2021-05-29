package com.pinus.pakis.ui.questions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pakis.pinus.core.domain.model.Questionnaire
import com.pakis.pinus.core.utils.DataQuestionnaire

class QuestionViewModel : ViewModel() {
    fun getQuestionnaire(): MutableLiveData<ArrayList<Questionnaire>> {
        return DataQuestionnaire.generateQuestionnaire()
    }
}