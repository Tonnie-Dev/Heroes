package com.uxstate.heroes.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.uxstate.heroes.R
import com.uxstate.heroes.presentation.ui.theme.Purple200
import com.uxstate.heroes.presentation.ui.theme.Purple500
import com.uxstate.heroes.presentation.ui.theme.Purple700

@RootNavGraph(start = true)
@Destination
@Composable
fun SplashScreen() {
Splash()
}

@Composable
fun Splash() {

    if (isSystemInDarkTheme()){} else{}

    Box(
            modifier = Modifier
                    .background(
                            brush = Brush.verticalGradient(
                                    listOf(
                                            Purple700,
                                            Purple200
                                    )
                            )
                    )
                    .fillMaxSize(),

            contentAlignment = Alignment.Center
    ) {

        Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(
                        R.string.app_logo
                )
        )

    }
}


@Preview()
@Composable
fun SplashScreenPreview() {

}