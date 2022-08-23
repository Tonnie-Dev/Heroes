package com.uxstate.heroes.presentation.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.uxstate.heroes.presentation.ui.theme.welcomeScreenBackgroundColor
@RootNavGraph(start = true)
@Destination
@Composable
fun WelcomeScreen() {

    val pages =
        listOf(OnboardingPage.FirstPage, OnboardingPage.SecondPage, OnboardingPage.ThirdPage)

    Column(modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.welcomeScreenBackgroundColor)) {

    }
}