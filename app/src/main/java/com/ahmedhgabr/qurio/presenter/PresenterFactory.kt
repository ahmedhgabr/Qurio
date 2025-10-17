package com.ahmedhgabr.qurio.presenter

import com.ahmedhgabr.qurio.presenter.repository.TriviaRepository
import com.ahmedhgabr.qurio.ui.BaseView
import com.ahmedhgabr.qurio.ui.home.HomeView
import javax.inject.Inject

class PresenterFactory  {
    @Inject
    lateinit var model: TriviaRepository

    fun providePresenter(view: BaseView): BasePresenter<out BaseView> {
        return when (view) {
            is HomeView -> HomePresenter(view, model)
            else -> throw IllegalArgumentException("No presenter found for the given view")
        }
    }
}