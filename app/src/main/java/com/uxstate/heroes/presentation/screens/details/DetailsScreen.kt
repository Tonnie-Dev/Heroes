package com.uxstate.heroes.presentation.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.presentation.screens.details.components.DetailsContent
import com.uxstate.heroes.util.Constants.BASE_URL
import com.uxstate.heroes.util.PaletteGenerator
import kotlinx.coroutines.flow.collectLatest

@Destination
@Composable
fun DetailsScreen(
    navigator: DestinationsNavigator,
    hero: Hero,
    viewModel: DetailsViewModel = hiltViewModel()
) {

    val colorPalette by viewModel.colorPalette

    if (colorPalette.isNotEmpty()) {
        DetailsContent(navigator = navigator, hero = hero)

    } else {
        viewModel.generateColorPalette()
    }


    val context = LocalContext.current


    //doesn't re-trigger during recomposition
    LaunchedEffect(key1 = true, block = {

        viewModel.uiEvent.collectLatest { uiEvent ->

            when (uiEvent) {

                is UIEvent.GenerateColorPalette -> {

                    //extract a bitmap from the selected hero image

                    val imageUrl = "$BASE_URL${hero.image}"
                    val bitMap = PaletteGenerator.convertImageUrlToBitmap(imageUrl, context)

                    //check if bitmap is null before extracting colors from it

                    if (bitMap != null) {
                        viewModel.setPalette(
                                PaletteGenerator.extractColorsFromBitmap(bitmap = bitMap)
                        )
                    }
                }
            }
        }

    })

}