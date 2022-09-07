package com.uxstate.heroes.presentation.screens.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import com.uxstate.heroes.presentation.ui.theme.starColor

@Composable
fun HalfFilledStar(
    starPath: Path,
    pathBounds: Rect,
    scaleFactor: Float
) {



    //Canvas
    Canvas(modifier = Modifier, onDraw = {


        drawPath(path = starPath, color = starColor)

    })
}