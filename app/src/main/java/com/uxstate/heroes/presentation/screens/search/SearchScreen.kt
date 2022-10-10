package com.uxstate.heroes.presentation.screens.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.heroes.presentation.common.ListContent
import com.uxstate.heroes.presentation.screens.search.components.SearchWidget
import com.uxstate.heroes.presentation.ui.theme.statusBarColor
import timber.log.Timber

@Destination
@Composable
fun SearchScreen(
    navigator: DestinationsNavigator,
    viewModel: SearchViewModel = hiltViewModel()
) {

    val uiController = rememberSystemUiController()
    uiController.setStatusBarColor(color = MaterialTheme.colors.statusBarColor)

    val query = viewModel.searchQuery

    //heroes will be passed to this screen using a lazy column
    val heroes = viewModel.searchedHeroes.collectAsLazyPagingItems()
    Scaffold(
            topBar = {
                SearchWidget(
                        text = query,
                        onTextChange = viewModel::updateSearchQuery,
                        onSearch = viewModel::searchedHeroes,
                        onClose = {

                            //pop back stack to exit search screen back to
                            // take us to home screen
                            navigator.popBackStack()
                        })
            },
            content = { paddingValues ->
                ListContent(
                        heroes = heroes,
                        navigator = navigator,
                        modifier = Modifier.padding(paddingValues)
                )
            })
}