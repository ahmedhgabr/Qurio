package com.ahmedhgabr.qurio.presenter.game

import com.ahmedhgabr.qurio.presenter.BasePresenter
import com.ahmedhgabr.qurio.presenter.repository.TriviaRepository
import com.ahmedhgabr.qurio.ui.game.GameView
import com.ahmedhgabr.qurio.ui.home.HomeView
import javax.inject.Inject

class GamePresenter @Inject constructor(
    private val model: TriviaRepository
) : BasePresenter<GameView>(), GamePresenterI {


    override fun loadQuestions(questionCount: Int, categoryId: Int, difficulty: String) {
        tryToExecute(
            function = {
                model.getQuestions(questionCount, categoryId, difficulty)
            },
            onSuccess = { categories ->
                view?.showQuestions(categories)
            },
            onError = { error ->
                view?.showError(error)
            }
        )
    }
}
