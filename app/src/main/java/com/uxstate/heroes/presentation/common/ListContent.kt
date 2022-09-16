package com.uxstate.heroes.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.paging.compose.LazyPagingItems
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.heroes.R
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.presentation.screens.destinations.DetailsScreenDestination
import com.uxstate.heroes.presentation.ui.theme.topAppBarContentColor
import com.uxstate.heroes.util.Constants.BASE_URL
import com.uxstate.heroes.util.LocalSpacing

@Composable
fun ListContent(heroes: LazyPagingItems<Hero>, navigator: DestinationsNavigator) {

}

@Composable
fun HeroItem(navigator: DestinationsNavigator, hero: Hero) {

    val spacing = LocalSpacing.current
    val url = "$BASE_URL${hero.image}"
    val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                    .data(url)
                    .placeholder(R.drawable.ic_placeholder)
                    .error(R.drawable.ic_placeholder)
    )

    Box(
            modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 2f)
                    .clickable {
                        navigator.navigate(DetailsScreenDestination)
                    }) {


        //Surface 1 - Image
        Surface(shape = MaterialTheme.shapes.large) {

            Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painter,
                    contentDescription = hero.name,
                    contentScale = ContentScale.Crop
            )

        }

        //Surface 2 - Overlay 40% of the height
        Surface(
                modifier = Modifier
                        .fillMaxHeight(.4f)
                        .fillMaxSize(),

                color = Color.Black.copy(alpha = ContentAlpha.medium),
                shape = RoundedCornerShape(
                        bottomStart = spacing.spaceMedium,
                        bottomEnd = spacing.spaceMedium
                )


        ) {
            Column(
                    modifier = Modifier
                            .fillMaxSize()
                            .padding(spacing.spaceMedium)
            ) {


                //name text
                Text(
                        text = hero.name,
                        color = MaterialTheme.colors.topAppBarContentColor,
                        fontSize = MaterialTheme.typography.h5.fontSize,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                )
            }
        }

    }

}