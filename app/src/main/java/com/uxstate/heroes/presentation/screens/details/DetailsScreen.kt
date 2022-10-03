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
import timber.log.Timber

@Destination
@Composable
fun DetailsScreen(
    navigator: DestinationsNavigator,
    hero: Hero,
    viewModel: DetailsViewModel = hiltViewModel()
) {
//whenever this changes a recomposition is done - if-block will execute
val colorPalette = viewModel.colorsPalette
    Timber.i("DetailsScreen composable called")


    //1st time the colorPalette from VM will be empty meaning else block will trigger
    if (colorPalette.isNotEmpty()) {

        Timber.i("Inside Details Screen - if")
        //upon recomposition
        DetailsContent(navigator = navigator, hero = hero, colors = colorPalette)

    } else {

        Timber.i("Inside Details Screen - else")
        //trigger VM to emit a UIEVent collected in the Launch block

        viewModel.generateColorPalette()

        //DetailsContent(navigator = navigator, hero = hero, colors = colorPalette)
    }


    val context = LocalContext.current


    //doesn't re-trigger during recomposition
    LaunchedEffect(key1 = true, block = {

        Timber.i("Entering the LaunchBlock")
        viewModel.eventFlow.collectLatest{

            event ->

            Timber.i("Inside the collectLatestBlock")
            //immediately extracts colors from bitmap and set them on VM color palette
            when (event) {

                is UIEvent.GenerateColorPalette -> {
                    Timber.i("Latest UIEvent signal collected in Launch Block")
                    //extract a bitmap from the selected hero image

                    val imageUrl = "$BASE_URL${hero.image}"
                    Timber.i("Image url is $imageUrl")
                    val bitMap = PaletteGenerator.convertImageUrlToBitmap(imageUrl, context)

                    //check if bitmap is null before extracting colors from it

                    Timber.i("Bitmap nullability: ${bitMap ==null}")
                    if (bitMap != null) {

                        Timber.i("Bitmap is not null")
                        viewModel.setPalette(
                                PaletteGenerator.extractColorsFromBitmap(bitmap = bitMap)
                        )
                    }


                }

             
            }
        }
        Timber.i("Exiting the Launch Block")
    }

    )

    Timber.i("End of DetailsScreen composable reached")

}