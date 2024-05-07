package com.ilesha23.football.ui.newGameScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class NewGameViewModel @Inject constructor(

) : ViewModel() {

    val date = MutableStateFlow(System.currentTimeMillis())
    val time = MutableStateFlow("")
    val owners = MutableStateFlow("")
    val guests = MutableStateFlow("")

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