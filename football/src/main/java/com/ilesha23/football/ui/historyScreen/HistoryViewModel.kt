package com.ilesha23.football.ui.historyScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilesha23.football.data.model.MatchItem
import com.ilesha23.football.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val historyList = MutableStateFlow<List<MatchItem>>(emptyList())

    init {
        viewModelScope.launch {
            historyList.update {
                repository.get()
            }
        }
    }

}