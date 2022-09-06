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
import kotlin.math.roundToInt

@Composable
fun FilledStar(starPath: Path, starPathBounds: Rect, scaleFactor: Float = 1f) {

    //Add Canvas
    Canvas(modifier = Modifier.size(24.dp), onDraw = {

        //reference to the canvas size
        val canvasSize = this.size

        //bounds dimens
        val pathWidth = starPathBounds.width
        val pathHeight = starPathBounds.height


     val x1 = (canvasSize.width - pathWidth)/2
        val y1 = (canvasSize.height - pathHeight)/2

        val x = (canvasSize.width/2 - pathWidth/2)
        val y = (canvasSize.width/2 - pathHeight/2)

        //Translate the coordinate space by the given delta in pixels in
        // both the x and y coordinates
        translate(top = x1, left = y1){

            //draw path
            drawPath(path = starPath, color = starColor)


        }

    })

}

//The background represents the Canvas
@Preview(name = "Filled Star", showBackground = false)
@Composable
fun FilledStarPreview() {

    RatingWidget(modifier = Modifier, rating = 1.0)

}