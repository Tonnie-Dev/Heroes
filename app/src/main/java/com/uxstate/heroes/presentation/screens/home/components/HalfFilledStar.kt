package com.uxstate.heroes.presentation.screens.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uxstate.heroes.presentation.ui.theme.starColor

@Composable
fun HalfFilledStar(
    starPath: Path,
    pathBounds: Rect,
    scaleFactor: Float = 1f

) {




    //Canvas
    Canvas(modifier = Modifier, onDraw = {

        val size = this.size

        val x = (size.width/2f) - (pathBounds.width/2f)
        val y = (size.height/2f) - (pathBounds.height/2f)

        translate(left = x, top = y){

            drawPath(path = starPath, color = starColor)
        }



    })
}


@Preview("HalfFilledStar", showBackground = true)
@Composable
fun HalfFilledStarPreview() {

    RatingWidget(modifier = Modifier, rating = 1.0)
}