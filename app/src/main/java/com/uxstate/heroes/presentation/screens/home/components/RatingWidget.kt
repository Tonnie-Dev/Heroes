package com.uxstate.heroes.presentation.screens.home.components

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import com.uxstate.heroes.R

@Composable
fun RatingWidget(modifier: Modifier, rating: Double, scaleFactor: Float = 3f) {

    val starPathString = stringResource(id = R.string.star_path)

    /*convert the string to to a Path/ PathNode instances*/
    val starPath = remember {
        PathParser().parsePathString(pathData = starPathString)
                .toPath()
    }


    //Compute the bounds of the control points of the path,
    // and write the answer into bounds
    val starPathBounds = remember {
        starPath.getBounds()

    }

    //FilledStar(starPath = starPath, starPathBounds = starPathBounds, scaleFactor)
    //HalfFilledStar(starPath = starPath, starPathBounds = starPathBounds, scaleFactor)
    EmptyStar(starPath = starPath, starPathBounds = starPathBounds, scaleFactor = scaleFactor)
}


/*This function takes a rating and returns a Map with String
and an Int representing the stars to be drawn*/

@Composable
fun calculateStars(rating: Double): Map<String, Int> {

    /* cache only - prevent expensive re-calculation operation on
     recomposition*/
    val maxStars = remember { 5 }

    /*cache, observe and trigger recomposition of any composable
    reading the value*/
    val filledStars by remember { mutableStateOf(0) }
    val halfFilledStars by remember { mutableStateOf(0) }
    val emptyStars by remember { mutableStateOf(0) }


    //triggered only when the rating changes
    LaunchedEffect(key1 = rating, block = {

        //split double to 2 separate integers
        val (firstNumber, lastNumber) = rating.toString()
                .split('.')
                .map { it.toInt() }


        if (firstNumber in 0..5 && lastNumber in 0..9){


        }

    })

}