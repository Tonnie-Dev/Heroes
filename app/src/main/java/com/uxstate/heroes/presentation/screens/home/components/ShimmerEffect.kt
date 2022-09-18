package com.uxstate.heroes.presentation.screens.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.heroes.presentation.ui.theme.ShimmerDarkGray
import com.uxstate.heroes.presentation.ui.theme.ShimmerLightGray
import com.uxstate.heroes.presentation.ui.theme.ShimmerMediumGray
import com.uxstate.heroes.util.LocalSpacing

@Composable
fun ShimmerEffect() {

}

@Composable
fun ShimmerItem() {

    val spacing = LocalSpacing.current

    Surface(
            modifier = Modifier.fillMaxWidth(),
            color = if (isSystemInDarkTheme()) Color.Black else ShimmerLightGray,
            shape = RoundedCornerShape(spacing.spaceMedium)
    ) {
        Column(
                modifier = Modifier.padding(spacing.spaceMedium),
                verticalArrangement = Arrangement.Bottom
        ) {


            Surface(
                    modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(spacing.spaceLarge),
                    color = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray,
                    shape = RoundedCornerShape(spacing.spaceSmall)
            ) {

            }
        }
    }
}

@Preview(name = "ShimmerPreview - Light", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun ShimmerPreviewLight() {

    ShimmerItem()

}


@Preview(name = "ShimmerPreview - Dark", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShimmerPreviewDark() {

    ShimmerItem()

}