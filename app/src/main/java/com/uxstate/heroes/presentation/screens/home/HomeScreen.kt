package com.uxstate.heroes.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.heroes.presentation.common.ListContent
import com.uxstate.heroes.presentation.screens.destinations.Destination
import com.uxstate.heroes.presentation.screens.destinations.SearchScreenDestination
import com.uxstate.heroes.presentation.screens.home.components.HomeTopBar
import com.uxstate.heroes.presentation.ui.theme.statusBarColor
import timber.log.Timber

@com.ramcosta.composedestinations.annotation.Destination
@Composable
fun HomeScreen( viewModel: HomeViewModel = hiltViewModel(), navigator: DestinationsNavigator) {

    val uiController = rememberSystemUiController()
    uiController.setStatusBarColor(color = MaterialTheme.colors.statusBarColor)

    val allHeroes = viewModel.getAllHeroes.collectAsLazyPagingItems()

    //Add Scaffold
    Scaffold( topBar = { HomeTopBar {navigator.navigate(SearchScreenDestination)}},

            content = { paddingValues ->

        ListContent(heroes = allHeroes, navigator =navigator, modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues))
    })


}