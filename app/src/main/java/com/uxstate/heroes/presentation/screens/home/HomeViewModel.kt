package com.uxstate.heroes.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.uxstate.heroes.domain.use_cases.UseCaseWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCaseWrapper: UseCaseWrapper) : ViewModel() {
}