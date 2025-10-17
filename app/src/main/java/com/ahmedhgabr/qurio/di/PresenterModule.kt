package com.ahmedhgabr.qurio.di
import com.ahmedhgabr.qurio.presenter.HomePresenter
import com.ahmedhgabr.qurio.presenter.HomePresenterI
import dagger.Binds
import dagger.Module

@Module
abstract class PresenterModule {
    @Binds
    abstract fun bindHomePresenter( presenter: HomePresenter): HomePresenterI
}