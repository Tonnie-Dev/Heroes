package com.uxstate.heroes.presentation.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DynamicRowTest() {
    Row(
            horizontalArrangement = Arrangement.SpaceEvenly,

            modifier = Modifier
                   // .wrapContentSize()
                    .background(LightGray)
    ) {
        Button(
                modifier = Modifier
                        //.defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
                ,
                onClick = { /*TODO*/ },
              //  contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                    text = "HELLO",
            )
        }
        Button(
                modifier = Modifier
                    //    .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
                ,
                onClick = { /*TODO*/ },
                //contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                    text = "HELLO",
            )
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRow() {
    Row( horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                    .wrapContentSize()
                    .background(LightGray)) {
        CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {}
        Button(
                modifier = Modifier
                        .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
                ,
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                    text = "HELLO",
            )
        }
        Button(
                modifier = Modifier
                        .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
                ,
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                    text = "HELLO",
            )
        }
    }
}
@Preview
@Composable
fun DynamicRowTestPreview() {

    DynamicRowTest()
}

@Preview
@Composable
fun MyRowPreview() {

   MyRow()
}

