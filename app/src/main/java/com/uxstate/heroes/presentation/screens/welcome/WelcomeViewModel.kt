package com.uxstate.heroes.presentation.screens.welcome

import androidx.lifecycle.ViewModel
import com.uxstate.heroes.domain.use_cases.UseCaseWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class WelcomeViewModel @Inject constructor(private val useCaseWrapper: UseCaseWrapper) : ViewModel() {
}
