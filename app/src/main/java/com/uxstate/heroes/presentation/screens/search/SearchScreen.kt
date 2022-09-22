package com.uxstate.heroes.presentation.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.uxstate.heroes.presentation.screens.search.components.SearchWidget

@Destination
@Composable
fun SearchScreen() {
    
    Scaffold(topBar = { SearchWidget(
            text = "",
            onTextChange = {},
            onSearch ={} ,
            onClose = { })
    }) { paddingValues ->   Column(modifier = Modifier.padding(paddingValues)) {

    }}
}