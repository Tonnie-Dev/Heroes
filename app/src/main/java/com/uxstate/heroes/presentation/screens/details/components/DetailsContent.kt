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
            sheetContent = { BottomSheetContent(hero = hero)},
            content = { BackgroundContent(heroImage = hero.image) {

            }}
    ) 

}