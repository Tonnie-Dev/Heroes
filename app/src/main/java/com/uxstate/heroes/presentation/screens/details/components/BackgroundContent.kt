package com.uxstate.heroes.presentation.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
import com.uxstate.heroes.util.LocalSpacing

@Composable
fun BackgroundContent(
    heroImage: String,
    imageFraction: Float = 1f,
    backgroundColor: Color = MaterialTheme.colors.surface,
    onCloseClicked: () -> Unit
) {

    val spacing = LocalSpacing.current

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

Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
    IconButton(onClick = onCloseClicked) {

        Icon(
                imageVector = Icons.Default.Close,
                contentDescription = stringResource(id = R.string.close_label),
                modifier = Modifier
                        .size(spacing.spaceLarge)
                        ,
                tint = Color.White
        )

    }
}




    }
}