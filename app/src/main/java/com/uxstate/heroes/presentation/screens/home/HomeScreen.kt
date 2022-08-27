package com.uxstate.heroes.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uxstate.heroes.presentation.screens.destinations.Destination
import com.uxstate.heroes.presentation.screens.home.components.HomeTopBar

@com.ramcosta.composedestinations.annotation.Destination
@Composable
fun HomeScreen() {

    //Add Scaffold

    Scaffold( topBar = { HomeTopBar {}}) { paddingValues ->

    Column(modifier = Modifier.padding(paddingValues)) {

    }

    }
}