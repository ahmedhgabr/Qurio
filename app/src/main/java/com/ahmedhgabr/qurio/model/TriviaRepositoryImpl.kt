package com.ahmedhgabr.qurio.model

import com.ahmedhgabr.qurio.model.remote.TriviaApi
import com.ahmedhgabr.qurio.model.remote.TriviaApiService
import com.ahmedhgabr.qurio.model.remote.dto.QuestionsResponse
import com.ahmedhgabr.qurio.model.remote.responseWrapper
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
}