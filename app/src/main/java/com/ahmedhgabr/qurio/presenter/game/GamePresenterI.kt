package com.ahmedhgabr.qurio.presenter.game

import com.ahmedhgabr.qurio.presenter.Presenter
import com.ahmedhgabr.qurio.ui.game.GameView

interface GamePresenterI : Presenter<GameView> {
    fun loadQuestions(questionCount: Int, categoryId: Int, difficulty: String)
}