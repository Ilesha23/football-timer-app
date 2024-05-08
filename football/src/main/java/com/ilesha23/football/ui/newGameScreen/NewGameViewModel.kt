package com.ilesha23.football.ui.newGameScreen

import androidx.lifecycle.ViewModel
import com.ilesha23.football.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class NewGameViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val date = MutableStateFlow(System.currentTimeMillis())
    val time = MutableStateFlow("00:00")
    val owners = MutableStateFlow("owners")
    val guests = MutableStateFlow("guests")

    fun start() {
        repository.currentMatch.apply {
            this.date = this@NewGameViewModel.date.value
            this.time = this@NewGameViewModel.time.value
            this.owners = this@NewGameViewModel.owners.value
            this.guests = this@NewGameViewModel.guests.value
        }
    }

    fun updateOwners(s: String) {
        owners.update {
            s
        }
    }

    fun updateGuests(s: String) {
        guests.update {
            s
        }
    }

    fun updateDate(millis: Long) {
        date.update {
            millis
        }
    }

    fun updateTime(s: String) {
        time.update {
            convertTimeFormat(s)
        }
    }

    fun convertTimeFormat(input: String): String {
        val regex = Regex("""\b\d{1}:\d{2}\b""")
        return if (regex.matches(input)) {
            val parts = input.split(":")
            "${parts[0].padStart(2, '0')}:${parts[1]}"
        } else {
            input
        }
    }

}