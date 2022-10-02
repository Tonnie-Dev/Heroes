package com.uxstate.heroes.presentation.screens.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {

    init {
        Timber.i("Init Block called inside DetailsViewModel")
    }

    /*with shared flow we are going to be able to trigger
    one time events and our events will not re-trigger
    even with screen rotation*/

    private val _uiEvent = MutableSharedFlow<UIEvent>()
    val uiEvent = _uiEvent.asSharedFlow()


    var colorsPalette by mutableStateOf<Map<String,String>>(mapOf())
    private set



    fun generateColorPalette() {


        //emit should only be called from a coroutine
        viewModelScope.launch {
            _uiEvent.emit(UIEvent.GenerateColorPalette)

            Timber.i("UIEvent detected inside DetailsViewModel")
        }

    }

    fun setPalette(colors:Map<String,String>){

Timber.i("The colors are $colors")
        colorsPalette = colors

    }



}