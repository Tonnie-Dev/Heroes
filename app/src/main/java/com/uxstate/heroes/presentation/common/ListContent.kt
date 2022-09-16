package com.uxstate.heroes.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.heroes.domain.model.Hero

@Composable
fun ListContent(heroes: LazyPagingItems<Hero>, navigator: DestinationsNavigator) {

}

@Composable
fun HeroItem(navigator: DestinationsNavigator, hero: Hero) {

    Box(
            modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 2f)
                    .clickable {

                    }) {

    }

}