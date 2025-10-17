package com.ahmedhgabr.qurio.ui.home

import com.ahmedhgabr.qurio.presenter.entity.Category
import com.ahmedhgabr.qurio.ui.BaseView

interface HomeView : BaseView {
    fun showCategories(categories: List<Category>)
}