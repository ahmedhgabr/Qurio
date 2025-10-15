package com.ahmedhgabr.qurio.model

import com.ahmedhgabr.qurio.presenter.repository.TriviaRepository

class TriviaRepositoryImpl : TriviaRepository {
    override fun getInfo(): String{
        return "This is a trivia info from TriviaRepositoryImpl"
    }

    override fun getRandomInfo(): String {
        val randomNumber = (1..100).random()
        return "This is a random number : $randomNumber"
    }
}