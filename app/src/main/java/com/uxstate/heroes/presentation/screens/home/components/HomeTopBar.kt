package com.uxstate.heroes.presentation.screens.home.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.heroes.R
import com.uxstate.heroes.presentation.ui.theme.topAppBarBackgroundColor
import com.uxstate.heroes.presentation.ui.theme.topAppBarContentColor

@Composable
fun HomeTopBar(onSearch: () -> Unit) {

    TopAppBar(title = {
        Text(
                text = stringResource(R.string.explore_label),
                color = MaterialTheme.colors.topAppBarContentColor
        )
    }, backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor, actions = {

        IconButton(onClick = { onSearch() }) {
            Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon)
            )
        }
    })
}


@Preview(name = "HomeTopBar")
@Composable
fun HomeTopBarPreview() {

}