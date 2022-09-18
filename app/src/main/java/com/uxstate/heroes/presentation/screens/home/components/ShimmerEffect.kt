package com.uxstate.heroes.presentation.screens.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.*
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uxstate.heroes.presentation.ui.theme.ShimmerDarkGray
import com.uxstate.heroes.presentation.ui.theme.ShimmerLightGray
import com.uxstate.heroes.presentation.ui.theme.ShimmerMediumGray
import com.uxstate.heroes.util.LocalSpacing

@Composable
fun ShimmerEffect() {
    val spacing = LocalSpacing.current
    LazyColumn(
            contentPadding = PaddingValues(spacing.spaceExtraSmall),
            verticalArrangement = Arrangement.spacedBy(spacing.spaceExtraSmall),
            content = {

                items(count = 2){

                    AnimatedShimmerItem()
                }

            })
}


@Composable
fun AnimatedShimmerItem() {

    //This will animate the Alpha state and will animate as
    //as the Shimmer is visible i.e indefinitely

    val transition = rememberInfiniteTransition()

    //holds the animated state of alpha
    val alphaValue by transition.animateFloat(
            //full visibility
            initialValue = 1f,

            //zero visibility
            targetValue = 0f,
            animationSpec = infiniteRepeatable(
                    animation = tween(
                            durationMillis = 500,
                            easing = FastOutSlowInEasing
                    ),
                    repeatMode = RepeatMode.Reverse
            )
    )


    ShimmerPlaceHolderItem(alphaValue = alphaValue)

}

@Composable
fun ShimmerPlaceHolderItem(alphaValue: Float) {

    val spacing = LocalSpacing.current

    Surface(
            modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(9f / 10f),
            color = if (isSystemInDarkTheme()) Color.Black else ShimmerLightGray,
            shape = RoundedCornerShape(spacing.spaceMedium)
    ) {
        Column(
                modifier = Modifier.padding(spacing.spaceMedium),
                verticalArrangement = Arrangement.Bottom
        ) {

            ShimmerBar(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    height = spacing.spaceLarge,
                    alphaValue = alphaValue
            )

            Spacer(modifier = Modifier.height(spacing.spaceSmall))

            repeat(3) {

                ShimmerBar(
                        modifier = Modifier.fillMaxWidth(),
                        height = spacing.spaceMedium,
                        alphaValue = alphaValue
                )
                Spacer(modifier = Modifier.height(spacing.spaceSmall))

            }

            Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))

            Row() {
                repeat(5) {

                    ShimmerBar(
                            modifier = Modifier.size(spacing.spaceLarge),
                            alphaValue = alphaValue
                    )
                    Spacer(modifier = Modifier.width(spacing.spaceExtraSmall))
                }
            }

        }
    }
}


@Composable
fun ShimmerBar(modifier: Modifier, height: Dp = 0.dp, alphaValue: Float) {

    val spacing = LocalSpacing.current
    Surface(
            modifier = modifier
                    .alpha(alphaValue)
                    .height(height),
            color = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray,
            shape = RoundedCornerShape(spacing.spaceExtraSmall)
    ) {

    }
}

@Preview(name = "ShimmerPreview - Light", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun ShimmerPreviewLight() {

    AnimatedShimmerItem()

}


@Preview(name = "ShimmerPreview - Dark", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShimmerPreviewDark() {

    AnimatedShimmerItem()

}