package com.ahmedhgabr.qurio.presenter.repository

import com.ahmedhgabr.qurio.presenter.entity.Category
import com.ahmedhgabr.qurio.presenter.entity.question.Question

interface TriviaRepository {
    suspend fun getToken(): String
    suspend fun getCategories(): List<Category>
    suspend fun getQuestions(amount: Int, category: Int?, difficulty: String?): List<Question>
}