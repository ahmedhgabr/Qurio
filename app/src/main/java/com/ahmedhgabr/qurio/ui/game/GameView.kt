package com.ahmedhgabr.qurio.ui.game

import com.ahmedhgabr.qurio.presenter.entity.question.Question
import com.ahmedhgabr.qurio.ui.BaseView

interface GameView : BaseView {
    fun onNextQuestionClicked()
    fun showNextQuestion(question: Question)
    fun goBack()
}