package com.ahmedhgabr.qurio.di
import com.ahmedhgabr.qurio.presenter.game.GamePresenter
import com.ahmedhgabr.qurio.presenter.game.GamePresenterI
import com.ahmedhgabr.qurio.presenter.home.HomePresenter
import com.ahmedhgabr.qurio.presenter.home.HomePresenterI
import dagger.Binds
import dagger.Module

@Module
abstract class PresenterModule {
    @Binds
    abstract fun bindHomePresenter( presenter: HomePresenter): HomePresenterI
    @Binds
    abstract fun bindGamePresenter( presenter: GamePresenter): GamePresenterI
}