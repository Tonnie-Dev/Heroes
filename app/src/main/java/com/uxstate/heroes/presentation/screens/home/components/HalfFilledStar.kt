package com.uxstate.heroes.presentation.screens.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uxstate.heroes.presentation.ui.theme.LightGray
import com.uxstate.heroes.presentation.ui.theme.starColor

@Composable
fun HalfFilledStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float = 1f

) {


    //Canvas
    Canvas(modifier = Modifier.size(24.dp), onDraw = {

        scale(scaleFactor) {
            val canvasSize = this.size
            //bounds dimens
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val x = (canvasSize.width/2f )- (pathWidth/1.7f)
            val y = (canvasSize.width/2f) - (pathHeight/1.7f)

            translate(left = x, top = y) {

                drawPath(
                        path = starPath,
                        color = LightGray.copy(alpha = 0.5f)
                )
            }
            //accepts path for bottom layer
            clipPath(starPath) {


                //draw scope

                drawRect(
                        color = starColor,

                        size = Size(

                                //Max.Dimens The greater of the magnitudes of the
                                // width and the height of this rectangle.
                                width = starPathBounds.maxDimension / 1.7f,
                                height = starPathBounds.maxDimension*scaleFactor
                        )
                )
            }


        }


    })
}


@Preview("HalfFilledStar", showBackground = true)
@Composable
fun HalfFilledStarPreview() {

    RatingWidget(modifier = Modifier, rating = 1.0)
}