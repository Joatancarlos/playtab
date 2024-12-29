package com.example.playtab.ui.screens

import com.example.playtab.network.PlayTabApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface LyricsUiState {
    data class Success(val lyrics: String) : LyricsUiState
    object Error : LyricsUiState
    object Loading : LyricsUiState
}
class LyricsViewModel : ViewModel() {
    var lyricsUiState: LyricsUiState by mutableStateOf(LyricsUiState.Loading)
        private set

    private fun getLyrics() {
        viewModelScope.launch {
            try {
                val lyricsResponse = PlayTabApi.retrofitService.getLyrics(
                    term = "love",
                )
                lyricsUiState = LyricsUiState.Success(lyricsResponse)

            } catch (e: IOException) {
                LyricsUiState.Error

            }
        }
    }

    init {
        getLyrics()
    }
}
