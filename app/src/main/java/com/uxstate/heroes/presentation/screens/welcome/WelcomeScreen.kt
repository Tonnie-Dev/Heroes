package com.uxstate.heroes.presentation.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.uxstate.heroes.presentation.ui.theme.welcomeScreenBackgroundColor
import com.uxstate.heroes.util.Constants

@OptIn(ExperimentalPagerApi::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun WelcomeScreen() {

    val state = rememberPagerState()
    val pages =
        listOf(OnboardingPage.FirstPage, OnboardingPage.SecondPage, OnboardingPage.ThirdPage)

    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colors.welcomeScreenBackgroundColor)
    ) {

        HorizontalPager(
                count = Constants.ON_BOARDING_PAGE_COUNT,
                state = state,
                verticalAlignment = Alignment.Top
        ) {

        }
    }
}