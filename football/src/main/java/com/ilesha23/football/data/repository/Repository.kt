package com.ilesha23.football.data.repository

import com.ilesha23.football.data.model.MatchItem

interface Repository {
    val currentMatch: MatchItem
    suspend fun insert(item: MatchItem)
    suspend fun get(): List<MatchItem>
}