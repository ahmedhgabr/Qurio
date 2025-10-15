package com.ahmedhgabr.qurio.presenter

import com.ahmedhgabr.qurio.model.TriviaRepositoryImpl
import com.ahmedhgabr.qurio.presenter.repository.TriviaRepository
import com.ahmedhgabr.qurio.ui.BaseView

open class BasePresenter {
    private val repository : TriviaRepository = TriviaRepositoryImpl()
    lateinit var view : BaseView
    fun getInfo() {
        val data = repository.getInfo()
        view.onInfoReceived(data)
    }

    fun getWisdom(){
        val data = repository.getRandomInfo()
        view.onRandomInfoReceived(data)
    }
}