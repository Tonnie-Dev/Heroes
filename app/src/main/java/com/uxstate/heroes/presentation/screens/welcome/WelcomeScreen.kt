package com.uxstate.heroes.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.uxstate.heroes.R
import com.uxstate.heroes.presentation.ui.theme.*
import com.uxstate.heroes.util.Constants
import com.uxstate.heroes.util.LocalSpacing

@OptIn(ExperimentalPagerApi::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun WelcomeScreen() {

    val spacing = LocalSpacing.current

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
                count = Constants.ONBOARDING_PAGE_COUNT,
                state = state,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.weight(.8f)
        ) {
            /*whenever we scroll sideways the page variable changes
            displaying the corresponding page */
            page ->
            PagerScreen(onboardingPage = pages[page])
        }

        //HorizontalPagerIndicator which is part of Accompanist Lib
        HorizontalPagerIndicator(
                pagerState = state,
                activeColor = MaterialTheme.colors.activeColorIndicator,
                inactiveColor = MaterialTheme.colors.inactiveColorIndicator,
                indicatorWidth = spacing.spaceMedium,
                spacing = spacing.spaceSmall,
                modifier = Modifier
                        .weight(.1f)
                        .align(CenterHorizontally)
        )

        //Finish Button

        FinishButton(pagerState = state, modifier = Modifier.weight(.1f)) {

        }
    }
}

@Composable
fun PagerScreen(onboardingPage: OnboardingPage) {

    val spacing = LocalSpacing.current

    Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Top
    ) {


        Image(
                modifier = Modifier
                        .fillMaxWidth(.5f)
                        .fillMaxHeight(.7f),
                painter = painterResource(id = onboardingPage.image),
                contentDescription = stringResource(
                        R.string.onboarding_image
                )
        )


        //Title
        Text(
                modifier = Modifier
                        .fillMaxWidth(),
                text = onboardingPage.title,
                color = MaterialTheme.colors.titleColor,
                fontSize = MaterialTheme.typography.h4.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
        )

        //Description
        Text(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = spacing.spaceLarge)
                        .padding(top = spacing.spaceSmall),
                text = onboardingPage.description,
                color = MaterialTheme.colors.descriptionColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
        )
    }

}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinishButton(modifier: Modifier = Modifier, pagerState: PagerState, onClick: () -> Unit) {

    val spacing = LocalSpacing.current
    Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Top
    ) {

        //set boolean to the last page
        AnimatedVisibility(visible = pagerState.currentPage == Constants.LAST_ONBOARDING_PAGE) {
            Button(
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.buttonBackgroundColor,
                            contentColor = Color.White
                    ),
                            modifier = Modifier . fillMaxWidth ().padding(horizontal = spacing.spaceExtraLarge)
            ) {

                Text(text = "Finish")
            }
        }
    }
}

@Preview(name = "First")
@Composable
fun FirstOnboardingScreenPreview() {

    Column(modifier = Modifier.fillMaxSize()) {

        PagerScreen(onboardingPage = OnboardingPage.FirstPage)

    }

}


@Preview(name = "Second")
@Composable
fun SecondOnboardingScreenPreview() {

    Column(modifier = Modifier.fillMaxSize()) {

        PagerScreen(onboardingPage = OnboardingPage.SecondPage)

    }

}


@Preview(name = "Third")
@Composable
fun ThirdOnboardingScreenPreview() {

    Column(modifier = Modifier.fillMaxSize()) {

        PagerScreen(onboardingPage = OnboardingPage.ThirdPage)

    }

}