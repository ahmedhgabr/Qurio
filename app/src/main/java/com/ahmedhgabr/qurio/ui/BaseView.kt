package com.ahmedhgabr.qurio.ui

interface BaseView {
//    fun showLoading()
//    fun hideLoading()
//    fun showError(message: String)
    fun onInfoReceived(info: String)
    fun onRandomInfoReceived(info: String)
}