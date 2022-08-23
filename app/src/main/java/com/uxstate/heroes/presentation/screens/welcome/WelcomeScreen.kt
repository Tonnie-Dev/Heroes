package com.uxstate.heroes.presentation.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.uxstate.heroes.R
import com.uxstate.heroes.presentation.ui.theme.titleColor
import com.uxstate.heroes.presentation.ui.theme.welcomeScreenBackgroundColor
import com.uxstate.heroes.util.Constants

@OptIn(ExperimentalPagerApi::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun WelcomeScreen() {

    // the state object to be used to control or observe the pager's state.
    val state = rememberPagerState()
    val pages =
        listOf(OnboardingPage.FirstPage, OnboardingPage.SecondPage, OnboardingPage.ThirdPage)

    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colors.welcomeScreenBackgroundColor)
    ) {


        //A horizontally scrolling layout that allows users to
        // flip between items to the left and right.
        HorizontalPager(
                count = Constants.ON_BOARDING_PAGE_COUNT,
                state = state,
                verticalAlignment = Alignment.Top
        ) {
            /*whenever we scroll sideways the page variable changes
            displaying the corresponding page */
            page ->
            PagerScreen(onboardingPage = pages[page])
        }
    }
}

@Composable
fun PagerScreen(onboardingPage: OnboardingPage) {


    Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {


        Image(
                painter = painterResource(id = onboardingPage.image),
                contentDescription = stringResource(
                        R.string.onboarding_image
                )
        )

        Text(
                text = onboardingPage.title,
                color = MaterialTheme.colors.titleColor,
                fontSize = MaterialTheme.typography.h4.fontSize,
                fontWeight = FontWeight.Bold
        )
    }

}