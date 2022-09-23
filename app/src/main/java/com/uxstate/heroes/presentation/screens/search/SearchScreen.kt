package com.uxstate.heroes.presentation.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.heroes.presentation.screens.search.components.SearchWidget

@Destination
@Composable
fun SearchScreen(navigator: DestinationsNavigator,
                 viewModel: SearchViewModel = hiltViewModel()) {

    val query = viewModel.searchQuery
    Scaffold(topBar = {
        SearchWidget(
                text = query,
                onTextChange = viewModel::updateSearchQuery,
                onSearch = {},
                onClose = {

                    //pop back stack to exit search screen back to
                    // take us to home screen
                    navigator.popBackStack()
                })
    }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

        }
    }
}