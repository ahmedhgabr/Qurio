package com.ahmedhgabr.qurio.presenter.home

import com.ahmedhgabr.qurio.presenter.Presenter
import com.ahmedhgabr.qurio.ui.home.HomeView

interface HomePresenterI : Presenter<HomeView> {
    fun loadCategories()
}