package com.ilesha23.football.ui.firstTimeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilesha23.football.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstTimeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val ownersScore = MutableStateFlow(0)
    val guestsScore = MutableStateFlow(0)

    private val _elapsedTime = MutableStateFlow<Long>(0)
    val elapsedTime = MutableStateFlow("00:00")

    private var startTime: Long = 0
    private var isRunning: Boolean = false

    init {
        _elapsedTime.value = 0
        startStopwatch()
    }

    fun startStopwatch() {
        if (!isRunning) {
            startTime = System.currentTimeMillis()
            isRunning = true
            viewModelScope.launch {
                while (isRunning) {
                    val elapsed = System.currentTimeMillis() - startTime
                    _elapsedTime.update {
                        elapsed
                    }
                    elapsedTime.update {
                        elapsed.toMinutesSeconds()
                    }
                    delay(1000)
                }
            }
        }
    }

    private fun stopStopwatch() {
        isRunning = false
    }

    fun addGuests() {
        guestsScore.update {
            it + 1
        }
    }

    fun addOwners() {
        ownersScore.update {
            it + 1
        }
    }

    fun subtractOwners() {
        ownersScore.update {
            if (it > 0) {
                it - 1
            } else it
        }
    }

    fun subtractGuests() {
        guestsScore.update {
            if (it > 0) {
                it - 1
            } else it
        }
    }


    fun stop() {
        stopStopwatch()
        repository.currentMatch.apply {
            this.ownersScore = this@FirstTimeViewModel.ownersScore.value
            this.guestsScore = this@FirstTimeViewModel.guestsScore.value
        }
    }

    private fun Long.toMinutesSeconds(): String {
        val minutes = this / 60000
        val seconds = (this % 60000) / 1000
        return "%02d:%02d".format(minutes, seconds)
    }

}