package com.ahmedhgabr.qurio.presenter.repository

interface TriviaRepository {
    fun getInfo(): String
    suspend fun getRandomInfo(): String
}