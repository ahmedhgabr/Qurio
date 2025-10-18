package com.ahmedhgabr.qurio.presenter.game

import android.util.Log
import androidx.core.text.parseAsHtml
import com.ahmedhgabr.qurio.presenter.BasePresenter
import com.ahmedhgabr.qurio.presenter.entity.question.Question
import com.ahmedhgabr.qurio.presenter.repository.TriviaRepository
import com.ahmedhgabr.qurio.ui.game.GameView
import com.ahmedhgabr.qurio.ui.home.HomeView
import javax.inject.Inject

class GamePresenter @Inject constructor(
    private val model: TriviaRepository
) : BasePresenter<GameView>(), GamePresenterI {

    var questionsList = mutableListOf<Question>()

    override fun loadQuestions(questionCount: Int, categoryId: Int, difficulty: String) {
        tryToExecute(
            function = {
                model.getQuestions(questionCount, categoryId, difficulty)
            },
            onSuccess = { questions ->
                questionsList = questions.toMutableList()
                showNextQuestion()
            },
            onError = { error ->
                view?.showError(error)
            }
        )
    }

    override fun showNextQuestion() {
        if (questionsList.isNotEmpty()) {
            val nextQuestion = questionsList.removeAt(0)
            view?.showNextQuestion(nextQuestion)
        } else {
            view?.goBack()
        }
    }
}
