package com.ilesha23.football.ui.firstTimeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilesha23.football.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstTimeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val ownersScore = MutableStateFlow(0)
    private val guestsScore = MutableStateFlow(0)

    private val _elapsedTime = MutableStateFlow<Long>(0)
    val elapsedTime = MutableStateFlow(_elapsedTime.value.toMinutesSeconds())

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
                    delay(1000)
                }
            }
        }
    }

    private fun stopStopwatch() {
        isRunning = false
    }

    fun addOwners() {
        ownersScore.update {
            it + 1
        }
    }

    fun addGuests() {
        guestsScore.update {
            it + 1
        }
    }

    fun stop() {
        stopStopwatch()
        repository.currentMatch.apply {
            this.ownersScore = this@FirstTimeViewModel.ownersScore.value
            this.guestsScore = this@FirstTimeViewModel.guestsScore.value
        }
    }

    fun Long.toMinutesSeconds(): String {
        val minutes = this / 60000
        val seconds = (this % 60000) / 1000
        return "%02d:%02d".format(minutes, seconds)
    }

}