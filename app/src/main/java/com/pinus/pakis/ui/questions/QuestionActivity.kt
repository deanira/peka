package com.pinus.pakis.ui.questions

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pinus.pakis.R
import com.pinus.pakis.databinding.ActivityQuestionBinding
import com.quickbirdstudios.surveykit.*
import com.quickbirdstudios.surveykit.backend.views.step.QuestionView
import com.quickbirdstudios.surveykit.result.TaskResult
import com.quickbirdstudios.surveykit.steps.CompletionStep
import com.quickbirdstudios.surveykit.steps.InstructionStep
import com.quickbirdstudios.surveykit.steps.QuestionStep
import com.quickbirdstudios.surveykit.steps.Step


class QuestionActivity : AppCompatActivity() {

    private val questionViewModel: QuestionViewModel by viewModels()
    lateinit var binding: ActivityQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        questionViewModel.getQuestionnaire().observe(this, { data ->
            val listQuestion: ArrayList<Step> = ArrayList()

            val inst = InstructionStep(
                title = "test",
                text = "test",
                buttonText = "test mulai"
            )
            listQuestion.add(inst)
            data.forEach { question ->
                val questions = QuestionStep(
                    title = question.id,
                    text = question.question,
                    answerFormat = AnswerFormat.SingleChoiceAnswerFormat(
                        listOf(
                            TextChoice("Setuju", "5"),
                            TextChoice("Agak Setuju", "4"),
                            TextChoice("Sedang", "3"),
                            TextChoice("Agak Tidak Setuju", "2"),
                            TextChoice("Tidak Setuju", "1")
                        )
                    )
                )
                listQuestion.add(questions)
            }

            val comp = CompletionStep(
                title = "finish",
                text = "finish",
                buttonText = "finish oke"
            )
            listQuestion.add(comp)

            val steps: List<Step> = listQuestion

            val task = OrderedTask(steps = steps)

            val configuration = SurveyTheme(
                themeColorDark = ContextCompat.getColor(this, R.color.cyan_normal_disabled),
                themeColor = ContextCompat.getColor(this, R.color.cyan_normal),
                textColor = ContextCompat.getColor(this, R.color.cyan_text)
            )

            binding.question.start(task, configuration)
        })

        binding.question.onSurveyFinish = { taskResult: TaskResult, reason: FinishReason ->
            if (reason == FinishReason.Completed) {
                taskResult.results.forEach { stepResult ->
                    Log.d("logTag", "answer ${stepResult.results.firstOrNull()?.stringIdentifier}")
                }
                finish()
            }
        }
    }
}