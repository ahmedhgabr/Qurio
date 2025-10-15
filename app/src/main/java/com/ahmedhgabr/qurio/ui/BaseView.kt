package com.ahmedhgabr.qurio.ui


interface BaseView {
//    fun showLoading()
//    fun hideLoading()
    fun onError(message: Throwable)
    fun onInfoReceived(info: String)
    fun onRandomInfoReceived(info: String)
}