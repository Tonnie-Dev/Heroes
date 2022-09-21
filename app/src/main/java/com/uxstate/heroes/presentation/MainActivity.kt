package com.uxstate.heroes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.DestinationsNavHost
import com.uxstate.heroes.presentation.screens.NavGraphs
import com.uxstate.heroes.presentation.ui.theme.HeroesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                ) {
                    //add the NavHost call
                    DestinationsNavHost(navGraph =NavGraphs.root )
                }




            }
        }
    }
}

