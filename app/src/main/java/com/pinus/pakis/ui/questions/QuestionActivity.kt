package com.pinus.pakis.ui.questions

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pinus.pakis.R
import com.pinus.pakis.databinding.ActivityQuestionBinding
import com.pinus.pakis.ui.result.ResultActivity
import com.quickbirdstudios.surveykit.*
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

        setupSurvey()
        surveyFinished()
    }

    private fun surveyFinished() {
        val answerFormat: ArrayList<String> = arrayListOf()
        binding.question.onSurveyFinish = { taskResult: TaskResult, reason: FinishReason ->
            if (reason == FinishReason.Completed) {
                taskResult.results.forEachIndexed loop@{ number, stepResult ->
                    if (number == 0 || number == 52) return@loop
                    else {
                        var anwer = stepResult.results.firstOrNull()?.stringIdentifier!!
                        answerFormat.add(
                            anwer
                        )
                    }
                }

                var answerInt: ArrayList<Int> = arrayListOf()
                answerFormat.forEachIndexed loopdua@{ number, answer ->
                    try {
                        answerInt.add(answer.trim().toInt())
                    } catch (e: Exception) {
                        Log.d("EXCEPTION", "$number ${e.cause.toString()}")
                    }
                }
                answerInt.add(3)

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_LIST", answerInt.toIntArray())
                startActivity(intent)
            }
            if (reason == FinishReason.Discarded) {
                Log.d("logTag", "cancelled")
                finish()
            }
        }
    }

    private fun setupSurvey() {
        questionViewModel.getQuestionnaire().observe(this, { data ->
            val listQuestion: ArrayList<Step> = ArrayList()

            val inst = InstructionStep(
                title = "Sebelum test dimulai",
                text = "Kuisioner ini akan diisi oleh anak anda, silahkan berikan gawai ini kepada anak anda",
                buttonText = "Mulai"
            )
            listQuestion.add(inst)

            data.forEachIndexed { number, question ->
                val nomor = number + 1
                val questions = QuestionStep(
                    title = nomor.toString(),
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
                title = "Kuisioner Selesai",
                text = "Terima Kasih, karena sudah mengisi kuisioner ini secara bijak dan jujur ini",
                buttonText = "Selesai"
            )
            listQuestion.add(comp)

            Log.d("SIZE", listQuestion.size.toString())

            val steps: List<Step> = listQuestion

            val task = OrderedTask(steps = steps)

            val configuration = SurveyTheme(
                themeColorDark = ContextCompat.getColor(this, R.color.cyan_normal_disabled),
                themeColor = ContextCompat.getColor(this, R.color.cyan_normal),
                textColor = ContextCompat.getColor(this, R.color.cyan_text)
            )
            binding.question.start(task, configuration)
        })
    }
}