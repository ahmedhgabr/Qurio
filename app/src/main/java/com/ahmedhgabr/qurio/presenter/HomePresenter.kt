package com.ahmedhgabr.qurio.presenter

import com.ahmedhgabr.qurio.presenter.repository.TriviaRepository
import com.ahmedhgabr.qurio.ui.home.HomeView
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

class HomePresenter @AssistedInject constructor(
    @Assisted view: HomeView,
    private val model: TriviaRepository
) : BasePresenter<HomeView>(view, model) {


    fun loadCategories() {
        tryToExecute(
            function = {
                model.getCategories()
            },
            onSuccess = { categories ->
                view.showCategories(categories)
            },
            onError = { error ->
                view.showError(error)
            }
        )
    }
}