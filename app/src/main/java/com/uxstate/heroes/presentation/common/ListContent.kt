package com.uxstate.heroes.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.paging.compose.LazyPagingItems
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.presentation.screens.destinations.DetailsScreenDestination
import com.uxstate.heroes.util.Constants.BASE_URL

@Composable
fun ListContent(heroes: LazyPagingItems<Hero>, navigator: DestinationsNavigator) {

}

@Composable
fun HeroItem(navigator: DestinationsNavigator, hero: Hero) {

    val url = "$BASE_URL${hero.image}"
    val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                    .data(url)
    )

    Box(
            modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 2f)
                    .clickable {
                        navigator.navigate(DetailsScreenDestination)
                    }) {

        Surface(shape = MaterialTheme.shapes.large) {

            Image(
                    painter = painter,
                    contentDescription = hero.name,
                    contentScale = ContentScale.Crop
            )

        }

    }

}