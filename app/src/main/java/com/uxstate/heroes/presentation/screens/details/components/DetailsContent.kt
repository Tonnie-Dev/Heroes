package com.uxstate.heroes.presentation.screens.details.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.util.LocalSpacing

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailsContent(navigator: DestinationsNavigator, hero: Hero) {

    val spacing = LocalSpacing.current
    val scaffoldState =
        rememberBottomSheetScaffoldState(
                bottomSheetState =
                BottomSheetState(initialValue = BottomSheetValue.Expanded)
        )
    
    BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetPeekHeight = spacing.spaceOneHundredFifty,
            sheetContent = { BottomSheetContent(hero = hero) },
            content = {


                BackgroundContent(
                        heroImage = hero.image,
                        imageFraction = scaffoldState.currentSheetFraction,
                        onCloseClicked = { navigator.popBackStack() })
            }
    )

}

@OptIn(ExperimentalMaterialApi::class)
val BottomSheetScaffoldState.currentSheetFraction: Float
    get() {
        val fraction = bottomSheetState.progress.fraction
        val targetValue = bottomSheetState.targetValue
        val currentValue = bottomSheetState.currentValue

        /*Timber.i("Fraction is: $fraction")
        Timber.i("Target is: $targetValue")
        Timber.i("Current is: $currentValue")*/
        return when {
            currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Collapsed -> 1f
            currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Expanded -> 0f
            currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Expanded -> 1f - fraction
            currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Collapsed -> 0f + fraction
            else -> fraction
        }
    }
