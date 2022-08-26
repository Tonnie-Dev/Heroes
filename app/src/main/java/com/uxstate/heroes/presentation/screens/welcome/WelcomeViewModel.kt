package com.uxstate.heroes.presentation.screens.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.heroes.domain.use_cases.UseCaseWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WelcomeViewModel @Inject constructor(private val useCaseWrapper: UseCaseWrapper) : ViewModel() {


  fun  saveOnboardingState(isCompleted:Boolean) {

      viewModelScope.launch (Dispatchers.IO){

          useCaseWrapper.saveOnboardingUseCase(isCompleted = isCompleted)

      }


  }
}
