package com.uxstate.heroes.presentation.screens.splash.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.heroes.R
import com.uxstate.heroes.util.LocalSpacing

@Composable
fun SearchTopBar(
    text: String,
    onTextChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {

}


@Composable
fun SearchWidget(
    text: String,
    onTextChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current

    Surface(modifier = modifier.padding(spacing.spaceSmall)) {


        Row() {

            TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = text,
                    onValueChange = onTextChange,
                    placeholder = { Text(text = "Search Here ...") },
                    leadingIcon = {
                        Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = stringResource(
                                        R.string.search_lable
                                )
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = onClose) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = "Close")
                        }
                    })
        }
    }

}


@Preview(name = "Light", uiMode = UI_MODE_NIGHT_NO, showSystemUi = true, showBackground = true)
@Composable
fun SearchWidgetPreviewLight() {

    SearchWidget(text = "", onTextChange = {}, onSearch = {}, onClose = { })

}


@Preview(name = "Dark", uiMode = UI_MODE_NIGHT_YES, showSystemUi = true, showBackground = true)
@Composable
fun SearchWidgetPreviewDark() {

    SearchWidget(text = "", onTextChange = {}, onSearch = {}, onClose = { })

}