package com.uxstate.heroes.presentation.screens.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {
    var colorsPalette by mutableStateOf<Map<String, String>>(mapOf())
        private set

    /*with shared flow we are going to be able to trigger
        one time events and our events will not re-trigger
        even with screen rotation*/

    /* var eventFlow = MutableSharedFlow<UIEvent>()
         private set*/

    /*private val _uiEvent = MutableSharedFlow<UIEvent>()
    val uiEvent: SharedFlow<UIEvent> = _uiEvent.asSharedFlow()*/


    //channel
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun generateColorPalette() {

        //emit should only be called from a coroutine
        viewModelScope.launch {

            //eventFlow.emit(UIEvent.GenerateColorPalette)
            _uiEvent.send(UIEvent.GenerateColorPalette)

        }

    }

    fun setPalette(colors: Map<String, String>) {

        colorsPalette = colors

    }


}