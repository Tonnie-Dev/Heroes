package com.uxstate.heroes.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    val icon by remember {
        mutableStateOf(R.drawable.ic_placeholder)
    }

    Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {

        //Icon

        Icon(
                modifier = Modifier.size(spacing.spaceOneHundredFifty),
                painter = painterResource(id = icon),
                contentDescription = stringResource(R.string.network_error_icon),
                tint = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray
        )

        //Text

        Text(
                modifier = Modifier.padding(top = spacing.spaceSmall),
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
        message.contains("ConnectionException") -> "Internet Unavailable"

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