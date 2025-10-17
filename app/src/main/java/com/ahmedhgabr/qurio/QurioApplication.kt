package com.ahmedhgabr.qurio

import android.app.Application
import com.ahmedhgabr.qurio.di.AppComponent
import com.ahmedhgabr.qurio.di.AppModule
import com.ahmedhgabr.qurio.di.DaggerAppComponent

class QurioApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory()
            .create(application = this)

        appComponent.inject(this)
    }
}