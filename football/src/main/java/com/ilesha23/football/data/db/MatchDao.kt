package com.ilesha23.football.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ilesha23.football.data.model.MatchItem

@Dao
interface MatchDao {
    @Query("select * from matchitem")
    fun getAll(): List<MatchItem>

    @Insert
    fun insert(item: MatchItem)
}