package com.uxstate.heroes.presentation.screens.home.components

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.uxstate.heroes.R
import com.uxstate.heroes.presentation.ui.theme.topAppBarBackgroundColor
import com.uxstate.heroes.presentation.ui.theme.topAppBarContentColor

@Composable
fun HomeTopBar() {

    TopAppBar(title = {Text(
            text = stringResource(R.string.explore_label),
            color = MaterialTheme.colors.topAppBarContentColor
    )}, backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor, actions = { Icon(
            imageVector = Icons.Default.Search,
            contentDescription = stringResource(R.string.search_icon)
    )})
}