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
    pathBounds: Rect,
    scaleFactor: Float = 1f

) {


    //Canvas
    Canvas(modifier = Modifier.size(24.dp), onDraw = {

        scale(scaleFactor) {
            val canvasSize = this.size

            val x = (canvasSize.width / 2f) - (pathBounds.width / 2f)
            val y = (canvasSize.height / 2f) - (pathBounds.height / 2f)

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
                                width = pathBounds.maxDimension / 1.7f,
                                height = pathBounds.maxDimension*scaleFactor
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