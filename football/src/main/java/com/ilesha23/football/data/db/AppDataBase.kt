package com.ilesha23.football.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ilesha23.football.data.model.MatchItem

@Database(
    entities = [MatchItem::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun matchDao(): MatchDao
}