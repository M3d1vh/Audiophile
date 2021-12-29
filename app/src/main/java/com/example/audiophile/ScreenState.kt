package com.example.audiophile

import com.example.audiophile.model.Headphone

sealed class ScreenState {
    data class DataLoaded(val headphones: List<Headphone>) : ScreenState()
    object Loading : ScreenState()
    data class Error(val error: String) : ScreenState()
}
