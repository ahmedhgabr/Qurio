package com.ahmedhgabr.qurio.presenter.home

import com.ahmedhgabr.qurio.presenter.BasePresenter
import com.ahmedhgabr.qurio.presenter.repository.TriviaRepository
import com.ahmedhgabr.qurio.ui.home.HomeView
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val model: TriviaRepository
) : BasePresenter<HomeView>(), HomePresenterI {


    override fun loadCategories() {
        tryToExecute(
            function = {
                model.getCategories()
            },
            onSuccess = { categories ->
                view?.showCategories(categories)
            },
            onError = { error ->
                view?.showError(error)
            }
        )
    }
}