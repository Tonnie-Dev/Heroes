package com.uxstate.heroes.presentation.screens.details

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {

    /*with shared flow we are going to be able to trigger
    one time events and our events will not re-trigger
    even with screen rotation*/

}