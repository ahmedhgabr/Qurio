package com.ahmedhgabr.qurio.di

import com.ahmedhgabr.qurio.model.TriviaRepositoryImpl
import com.ahmedhgabr.qurio.presenter.repository.TriviaRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindTriviaRepository(
        triviaRepositoryImpl: TriviaRepositoryImpl
    ): TriviaRepository

}