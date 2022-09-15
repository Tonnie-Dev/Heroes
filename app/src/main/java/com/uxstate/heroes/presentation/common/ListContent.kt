package com.uxstate.heroes.presentation.common

import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.heroes.domain.model.Hero

@Composable
fun ListContent(heroes:LazyPagingItems<Hero>, navigator: DestinationsNavigator) {

}

@Composable
fun HeroItem(navigator: DestinationsNavigator, hero: Hero) {

}