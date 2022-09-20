package com.uxstate.heroes.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.paging.LoadState
import com.uxstate.heroes.R

@Composable
fun EmptyScreen(error: LoadState.Error) {

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


        Image(
                painterResource(id = icon),
                contentDescription = message,
                contentScale = ContentScale.Crop
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