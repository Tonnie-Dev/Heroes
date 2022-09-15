package com.uxstate.heroes.presentation.screens.home.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size

import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EmptyStar(
    starPathBounds: Rect,
    starPath: Path,
    scaleFactor: Float
) {

Canvas(modifier = Modifier.size(24.dp), onDraw = {
    val width = starPathBounds.width
    val height = starPathBounds.height


    val x = (this.size.width)/2- width/2
    val y = (this.size.height)/2 - height/2

   scale(scale = scaleFactor){


       translate(left = x , top = y){


           drawPath(path = starPath, color = Color.LightGray.copy(alpha = 0.5f))
       }
   }

})



}


@Preview(name = "EmptyStars", showBackground = true)
@Composable
fun EmptyStarPreview() {

RatingWidget(modifier = Modifier, rating = 2.0)
}


