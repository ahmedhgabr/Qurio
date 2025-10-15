package com.ahmedhgabr.qurio.presenter.repository

interface TriviaRepository {
    fun getInfo(): String
    fun getRandomInfo(): String
}