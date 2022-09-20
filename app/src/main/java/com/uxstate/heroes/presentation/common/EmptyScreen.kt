package com.uxstate.heroes.presentation.common

import androidx.compose.runtime.*
import androidx.paging.LoadState

@Composable
fun EmptyScreen(error: LoadState.Error) {

    val message by remember{ mutableStateOf(parseErrorMessage(error.error)) }

}

fun parseErrorMessage(message: String): String {

    return when {
        message.contains("SocketTimeoutException") -> "Server Unavailable"
        message.contains("ConnectionException") -> "Internet Unavailable"

        else -> "Unknown Error"
    }

}