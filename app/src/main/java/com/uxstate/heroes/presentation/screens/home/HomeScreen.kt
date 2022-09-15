package com.uxstate.heroes.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.heroes.presentation.common.ListContent
import com.uxstate.heroes.presentation.screens.destinations.Destination
import com.uxstate.heroes.presentation.screens.home.components.HomeTopBar

@com.ramcosta.composedestinations.annotation.Destination
@Composable
fun HomeScreen( viewModel: HomeViewModel = hiltViewModel(), navigator: DestinationsNavigator) {


    val allHeroes = viewModel.getAllHeroes.collectAsLazyPagingItems()
    //Add Scaffold

    Scaffold( topBar = { HomeTopBar {}}, content = { paddingValues ->

        ListContent(heroes = allHeroes, navigator =navigator)
    })


}