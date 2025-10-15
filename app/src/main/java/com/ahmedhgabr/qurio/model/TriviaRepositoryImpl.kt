package com.ahmedhgabr.qurio.model

import com.ahmedhgabr.qurio.model.mapper.toCategory
import com.ahmedhgabr.qurio.model.mapper.toQuestion
import com.ahmedhgabr.qurio.model.remote.TriviaApi
import com.ahmedhgabr.qurio.model.remote.TriviaApiService
import com.ahmedhgabr.qurio.model.remote.dto.QuestionsResponse
import com.ahmedhgabr.qurio.model.remote.responseWrapper
import com.ahmedhgabr.qurio.presenter.entity.Category
import com.ahmedhgabr.qurio.presenter.entity.question.Question
import com.ahmedhgabr.qurio.presenter.repository.TriviaRepository

class TriviaRepositoryImpl() : TriviaRepository {
    val triviaApiService: TriviaApiService = TriviaApi.retrofitService
    override fun getInfo(): String {
        return "This is a trivia info from TriviaRepositoryImpl"
    }

    override suspend fun getRandomInfo(): String {
        val question: QuestionsResponse = responseWrapper {
            triviaApiService.getQuestions(1, null, null, null)
        }
        return question.results.firstOrNull()?.question ?: "No question found"
    }

    override suspend fun getToken(): String {
        val tokenResponse = responseWrapper {
            triviaApiService.getToken()
        }
        return tokenResponse.token
    }

    override suspend fun getCategories(): List<Category> {
        val categoriesResponse = responseWrapper {
            triviaApiService.getCategories()
        }
        return categoriesResponse.triviaCategories.map { categoryDTO -> categoryDTO.toCategory() }
    }

    override suspend fun getQuestions(
        amount: Int,
        category: Int?,
        difficulty: String?
    ): List<Question> {
        val token = getToken()
        val questionsResponse = responseWrapper {
            triviaApiService.getQuestions(amount, category, difficulty, token)
        }
        return questionsResponse.results.map { questionDTO -> questionDTO.toQuestion() }
    }


}