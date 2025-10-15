package com.ahmedhgabr.qurio.presenter.entity.question

data class Question(
    val category: String,
    val difficulty: Difficulty,
    val question: String,
    val correctAnswer: String,
    val options: List<String>
)
