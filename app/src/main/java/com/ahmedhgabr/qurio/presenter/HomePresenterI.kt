package com.ahmedhgabr.qurio.presenter

import com.ahmedhgabr.qurio.ui.home.HomeView

interface HomePresenterI : Presenter<HomeView> {
    fun loadCategories()
}