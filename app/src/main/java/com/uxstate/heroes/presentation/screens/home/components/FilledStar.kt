package com.uxstate.heroes.presentation.screens.home.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uxstate.heroes.presentation.ui.theme.starColor

@Composable
fun FilledStar(starPath: Path, starPathBounds: Rect, scaleFactor: Float = 1f) {

    //Add Canvas
    Canvas(modifier = Modifier.size(24.dp), onDraw = {

        //reference to the canvas size
        val canvasSize = this.size

        //draw path
        drawPath(path = starPath, color = starColor)

    })

}

@Preview(name = "Filled Star", showBackground = false)
@Composable
fun FilledStarPreview() {

    RatingWidget(modifier = Modifier, rating = 1.0)

}