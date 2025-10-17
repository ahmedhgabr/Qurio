package com.ahmedhgabr.qurio.di

import android.app.Application
import com.ahmedhgabr.qurio.MainActivity
import com.ahmedhgabr.qurio.QurioApplication
import com.ahmedhgabr.qurio.ui.game.GameFragment
import com.ahmedhgabr.qurio.ui.home.HomeFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, RepositoryModule::class, PresenterModule::class])
interface AppComponent {
    fun inject(app: QurioApplication)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: GameFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}