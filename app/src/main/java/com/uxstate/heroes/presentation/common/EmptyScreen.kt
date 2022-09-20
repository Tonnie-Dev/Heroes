package com.uxstate.heroes.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import com.uxstate.heroes.R
import com.uxstate.heroes.util.LocalSpacing
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(error: LoadState.Error) {

    val spacing = LocalSpacing.current

    val message by remember {
        mutableStateOf(parseErrorMessage(error.toString()))
    }

    val icon = remember {
        R.drawable.ic_network_error
    }


    var start by remember {
        //make it observable to trigger recomposition
        mutableStateOf(false)


    }

    LaunchedEffect(key1 = start, block = {
        start = true
    })

    val alphaValue by
    animateFloatAsState(
            targetValue = if (start) ContentAlpha.disabled else 0f,
            animationSpec = tween(1000)
    )

    Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {

        //Icon

        Icon(
                modifier = Modifier
                        .size(spacing.spaceOneHundredFifty)
                        .alpha(alphaValue),
                painter = painterResource(id = icon),
                contentDescription = stringResource(R.string.network_error_icon),
                tint = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray
        )

        //Text

        Text(
                modifier = Modifier
                        .padding(top = spacing.spaceSmall)
                        .alpha(alphaValue),
                text = message,
                color = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
        )


    }

}

fun parseErrorMessage(message: String): String {

    return when {
        message.contains("SocketTimeoutException") -> "Server Unavailable"
        message.contains("ConnectException") -> "Internet Unavailable"

        else -> "Unknown Error"
    }

}

@Preview("EmptyScreen - Light", uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun EmptyScreenPreviewLight() {
    EmptyScreen(error = LoadState.Error(error = SocketTimeoutException()))
}

@Preview("EmptyScreen - Dark", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun EmptyScreenPreviewDark() {
    EmptyScreen(error = LoadState.Error(error = SocketTimeoutException()))
}