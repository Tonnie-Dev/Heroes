package com.uxstate.heroes.presentation.screens.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun OrderedList(title: String, items: List<String>, textColor: Color) {



    Column() {
        Text(
                text = title,
                color = textColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Bold
        )

     items.forEachIndexed { i, s ->


         Text(
                 text = "${i + 1}. $s",
                 color = textColor,
                 fontSize = MaterialTheme.typography.subtitle1.fontSize
         )
     }
    }

}