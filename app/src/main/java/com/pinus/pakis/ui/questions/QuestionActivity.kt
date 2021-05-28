package com.pinus.pakis.ui.questions

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pinus.pakis.R
import com.pinus.pakis.databinding.ActivityQuestionBinding
import com.quickbirdstudios.surveykit.*
import com.quickbirdstudios.surveykit.result.TaskResult
import com.quickbirdstudios.surveykit.steps.CompletionStep
import com.quickbirdstudios.surveykit.steps.InstructionStep
import com.quickbirdstudios.surveykit.steps.QuestionStep


class QuestionActivity : AppCompatActivity() {

    lateinit var binding: ActivityQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val inst = InstructionStep(
            title = "test",
            text = "test",
            buttonText = "test mulai"
        )

        val step1 = QuestionStep(
            title = "Masukan Nama Anda",
            text = "Mantap",
            answerFormat = AnswerFormat.TextAnswerFormat(
                5, "isi nama anda"
            )
        )

        val step2 = QuestionStep(
            title = "Masukan Nama Anda2",
            text = "Mantap2",
            answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                listOf(
                    TextChoice("aziz", "aziz"),
                    TextChoice("paijo", "paijo"),
                    TextChoice("Maman", "maman"),
                    TextChoice("emy", "emy")
                )
            )
        )

        val comp = CompletionStep(
            title = "finish",
            text = "finish",
            buttonText = "finish oke"
        )
        val steps = listOf(inst, step1, step2, comp)

        val task = OrderedTask(steps = steps)

        binding.question.onSurveyFinish = { taskResult: TaskResult, reason: FinishReason ->
            if (reason == FinishReason.Completed) {
                taskResult.results.forEach { stepResult ->
                    Log.d("logTag", "answer ${stepResult.results.firstOrNull()?.stringIdentifier}")
                }
                finish()
            }
        }

        val configuration = SurveyTheme(
            themeColorDark = ContextCompat.getColor(this, R.color.cyan_normal_disabled),
            themeColor = ContextCompat.getColor(this, R.color.cyan_normal),
            textColor = ContextCompat.getColor(this, R.color.cyan_text)
        )

        binding.question.start(task, configuration)
    }
}