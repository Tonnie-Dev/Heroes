package com.uxstate.heroes.presentation.screens.home.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import com.uxstate.heroes.R

@Composable
fun RatingWidget(modifier: Modifier, rating:Double) {

  val starPathString = stringResource(id = R.string.star_path)

    /*Parses the path string to create a collection of PathNode instances*/
    val starPath = remember{ PathParser().parsePathString(pathData = starPathString).toPath()}


  //Compute the bounds of the control points of the path,
  // and write the answer into bounds
    val starPathBounds = remember {
        starPath.getBounds()

    }


    FilledStar(starPath = starPath, starPathBounds = starPathBounds)
}