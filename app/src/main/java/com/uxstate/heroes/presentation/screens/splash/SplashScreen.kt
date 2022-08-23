package com.uxstate.heroes.presentation.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.uxstate.heroes.R
import com.uxstate.heroes.presentation.ui.theme.Purple200
import com.uxstate.heroes.presentation.ui.theme.Purple700


@Destination
@Composable
fun SplashScreen() {

    //create animatable rotation

    val rotation = remember { Animatable(initialValue = 0f) }

    //launched effect with true key to trigger once
    LaunchedEffect(key1 = true, block = {

        rotation.animateTo(
                targetValue = 360f,
                animationSpec = tween(durationMillis = 1000, delayMillis = 200)
        )
    })
    Splash(rotation.value)
}

@Composable
fun Splash(rotation: Float) {

    if (isSystemInDarkTheme()) {
        //Light Theme

        Box(
                modifier = Modifier
                        .background(color = Color.Black)
                        .fillMaxSize(),

                contentAlignment = Alignment.Center
        ) {

            Image(
                    modifier = Modifier.rotate(rotation),
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = stringResource(
                            R.string.app_logo
                    )
            )

        }

    } else {


        //Dark Theme
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
                        .fillMaxSize()
                        .rotate(rotation),

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


}


@Preview(name = "Light")
@Composable
fun SplashScreenPreviewLight() {
    SplashScreen()
}

@Preview(name = "Dark", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SplashScreenPreviewDark() {
    SplashScreen()
}



