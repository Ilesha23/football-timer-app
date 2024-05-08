package com.ilesha23.football.data

import com.ilesha23.football.data.model.MatchItem

interface Repository {
    val currentMatch: MatchItem
    suspend fun insert(item: MatchItem)
    suspend fun get(): List<MatchItem>
//    fun updateMatch(
//        date: Long,
//        time: String,
//        owners: String,
//        guests: String,
//        ownersScore: Int,
//        guestsScore: Int
//    )
}