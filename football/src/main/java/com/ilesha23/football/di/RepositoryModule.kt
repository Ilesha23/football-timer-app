package com.ilesha23.football.di

import com.ilesha23.football.data.repository.Repository
import com.ilesha23.football.data.repository.RepositoryImpl
import com.ilesha23.football.data.db.MatchDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(matchDao: MatchDao): Repository {
        return RepositoryImpl(matchDao)
    }

}