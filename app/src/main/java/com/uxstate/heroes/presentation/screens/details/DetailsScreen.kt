package com.uxstate.heroes.presentation.screens.details

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.presentation.screens.details.components.DetailsContent

@Destination
@Composable
fun DetailsScreen(navigator: DestinationsNavigator, hero: Hero) {

DetailsContent(navigator = navigator, hero = hero)

}