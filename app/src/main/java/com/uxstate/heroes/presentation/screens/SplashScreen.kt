package com.uxstate.heroes.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import com.uxstate.heroes.R
import com.uxstate.heroes.presentation.ui.theme.Purple500
import com.uxstate.heroes.presentation.ui.theme.Purple700

@Composable
fun SplashScreen() {

}

@Composable
fun Splash() {

    Box(
            modifier = Modifier
                    .background(
                            brush = Brush.verticalGradient(
                                    listOf(
                                            Purple700,
                                            Purple500
                                    )
                            )
                    )
                    .fillMaxSize(),
            
            contentAlignment = Alignment.Center
    ){
        
        Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = )
        
    }
}