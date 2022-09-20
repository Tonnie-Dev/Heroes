package com.uxstate.heroes.presentation.common

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import com.uxstate.heroes.R
import com.uxstate.heroes.util.LocalSpacing

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
    }

}

fun parseErrorMessage(message: String): String {

    return when {
        message.contains("SocketTimeoutException") -> "Server Unavailable"
        message.contains("ConnectionException") -> "Internet Unavailable"

        else -> "Unknown Error"
    }

}