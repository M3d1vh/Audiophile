package com.example.audiophile.presentation

import com.example.audiophile.domain.model.Headphone

sealed class ScreenState {
    data class DataLoaded(val headphones: List<Headphone>) : ScreenState()
    object Loading : ScreenState()
    data class Error(val error: String) : ScreenState()
}
