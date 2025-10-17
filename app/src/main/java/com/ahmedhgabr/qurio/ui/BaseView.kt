package com.ahmedhgabr.qurio.ui


interface BaseView {
    fun startLoading()

    fun endLoading()

    fun showError(message: Throwable)
}