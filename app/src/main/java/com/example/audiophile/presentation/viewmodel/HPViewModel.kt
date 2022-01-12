package com.example.audiophile.presentation.viewmodel

import android.content.Context
import com.example.audiophile.data.database.DatabaseProvider
import com.example.audiophile.data.database.HeadphoneDao
import com.example.audiophile.data.network.NetworkService
import com.example.audiophile.presentation.ScreenState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import java.io.IOException

class HPViewModel (
    private val context: Context,
    private val coroutineScope: CoroutineScope
) {
    private val HPDAO = DatabaseProvider.provideDatabase(context).hpDao()
    private val _screenState = MutableStateFlow<ScreenState> (ScreenState.Loading)
    val screenState : StateFlow<ScreenState> = _screenState
    private var job: Job? = null

    @ExperimentalSerializationApi
    fun loadData() {
        job = coroutineScope.launch {
            try{
                _screenState.value = ScreenState.Loading
                val headphones = try{
                    NetworkService.loadHeadphones().also{
                        HPDAO.insertAll(it)
                    }
                } catch (ex: IOException){
                    HPDAO.getAll()
                }
                _screenState.value = ScreenState.DataLoaded(headphones)
            } catch (ex: Throwable){
                _screenState.value = ScreenState.Error("Ошибка!")
            }
        }
    }
}