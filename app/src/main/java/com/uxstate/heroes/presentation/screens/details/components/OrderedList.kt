package com.uxstate.heroes.presentation.screens.details.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.heroes.presentation.ui.theme.titleColor
import com.uxstate.heroes.util.LocalSpacing

@Composable
fun OrderedList(title: String, items: List<String>, textColor: Color) {

    val spacing = LocalSpacing.current


       Column() {
           Text(
                   text = title,
                   color = textColor,
                   fontSize = MaterialTheme.typography.subtitle1.fontSize,
                   fontWeight = FontWeight.Bold,
                   modifier = Modifier.padding(bottom = spacing.spaceSmall)
           )

           items.forEachIndexed { i, s ->


               Text(
                       text = "${i + 1}. $s",
                       color = textColor,
                       fontSize = MaterialTheme.typography.body1.fontSize,
                       modifier = Modifier.alpha(ContentAlpha.medium)
               )
           }
       }


}


@Preview
@Composable
fun OrderedListPreview() {
    val names = listOf("Muchiri", "Njiri", "Muraguri", "Waruwe", "Gathigi", "Maina")

    OrderedList(
            title = "Family",
            items = names,
            textColor = MaterialTheme.colors.titleColor
    )

}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun OrderedListPreviewDark() {
    val names: List<String> = listOf("Muchiri", "Njiri", "Muraguri", "Waruwe", "Gathigi", "Maina")


        OrderedList(
                title = "Family",
                items = names,
                textColor = MaterialTheme.colors.titleColor
        )



}