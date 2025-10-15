package com.ahmedhgabr.qurio.model.mapper

import com.ahmedhgabr.qurio.presenter.entity.question.Difficulty
import com.ahmedhgabr.qurio.presenter.entity.question.Question
import com.ahmedhgabr.qurio.model.remote.dto.QuestionDTO
import com.ahmedhgabr.qurio.util.Constant


fun QuestionDTO.toQuestion(): Question {
    return Question(
        category = this.category,
        difficulty = when (this.difficulty.lowercase()) {
            Constant.EASY -> Difficulty.EASY
            Constant.MEDIUM -> Difficulty.MEDIUM
            Constant.HARD -> Difficulty.HARD
            else -> Difficulty.EASY
        },
        question = this.question,
        correctAnswer = this.correctAnswer,
        options = this.incorrectAnswers
    )
}