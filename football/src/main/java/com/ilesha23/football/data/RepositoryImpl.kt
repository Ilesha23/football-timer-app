package com.ilesha23.football.data

import com.ilesha23.football.data.db.MatchDao
import com.ilesha23.football.data.model.MatchItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
//    private val dao: MatchDao
) : Repository {
    override val currentMatch: MatchItem = MatchItem()

    override suspend fun insert(item: MatchItem) {
        withContext(Dispatchers.IO) {
//            dao.insert(item)
        }
    }

    override suspend fun get(): List<MatchItem> {
//        return dao.getAll()
        return emptyList()
    }
}