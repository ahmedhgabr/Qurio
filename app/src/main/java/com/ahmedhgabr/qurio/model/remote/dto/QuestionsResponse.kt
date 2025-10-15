package com.ahmedhgabr.qurio.model.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestionsResponse(
    @SerialName("response_code")
    override val responseCode: Int? = null,
    val results: List<QuestionDTO>
) : BaseResponse

/**
 * @param type: "multiple" or "boolean",
 * @param difficulty: "easy", "medium", "hard"
 */
@Serializable
data class QuestionDTO(
    val type: String,
    val difficulty: String,
    val category: String,
    val question: String,
    @SerialName("correct_answer")
    val correctAnswer: String,
    @SerialName("incorrect_answers")
    val incorrectAnswers: List<String>
)


