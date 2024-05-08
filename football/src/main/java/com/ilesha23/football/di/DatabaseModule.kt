package com.ilesha23.football.di

import android.content.Context
import androidx.room.Room
import com.ilesha23.football.data.db.DataBase
import com.ilesha23.football.data.db.MatchDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DataBase {
        return Room.databaseBuilder(
            context,
            DataBase::class.java,
            "db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(db: DataBase): MatchDao {
        return db.matchDao()
    }

}