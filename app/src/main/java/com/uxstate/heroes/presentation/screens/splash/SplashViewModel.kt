package com.uxstate.heroes.presentation.screens.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.heroes.domain.use_cases.UseCaseWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(useCaseWrapper: UseCaseWrapper) : ViewModel() {

    //var isOnboardingCompleted by mutableStateOf(false)

   private val _isOnboardingCompleted = MutableStateFlow(false)
    val isOnboardingCompleted = _isOnboardingCompleted




    init {

        viewModelScope.launch {

            _isOnboardingCompleted.value = useCaseWrapper.readOnboardingUseCase().stateIn(viewModelScope).value
        }
    }
}