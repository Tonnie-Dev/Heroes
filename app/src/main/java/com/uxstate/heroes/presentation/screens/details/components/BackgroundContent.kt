package com.uxstate.heroes.presentation.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.uxstate.heroes.R
import com.uxstate.heroes.util.Constants.BASE_URL

@Composable
fun BackgroundContent(
    heroImage: String,
    imageFraction: Float = 1f,
    backgroundColor: Color = MaterialTheme.colors.surface,
    onCloseClicked: () -> Unit
) {


    val imageUrl = "$BASE_URL$heroImage"
    val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .build()
    )
    Box(
            modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundColor)
    ) {

        Image(
                painter = painter,
                contentDescription = stringResource(R.string.hero_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(imageFraction)
                        .align(Alignment.TopStart)
        )

    }
}