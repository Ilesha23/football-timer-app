package com.ilesha23.football.di

import android.content.Context
import androidx.room.Room
import com.ilesha23.football.data.db.AppDataBase
import com.ilesha23.football.data.db.MatchDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideAppDataBase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(db: AppDataBase): MatchDao {
        return db.matchDao()
    }

}