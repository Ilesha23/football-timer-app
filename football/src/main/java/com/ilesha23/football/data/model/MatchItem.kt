package com.ilesha23.football.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MatchItem(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var date: Long = 0,
    var time: String = "00:00",
    var owners: String = "owners",
    var guests: String = "guests",
    var ownersScore: Int = 0,
    var guestsScore: Int = 0,
)
