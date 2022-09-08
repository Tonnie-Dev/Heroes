package com.uxstate.heroes.presentation.screens.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Test(
    val title: String,
    val text: String
)

@Composable
fun CardRowSample(
    modifier: Modifier = Modifier,
) {
    val testList =
        listOf(
                Test("AAAA", "1,2,3,4,5,6,7,8,9,10"),
                Test("BBBB", "11,12,13,14,15,16,17,18,19,20")
        )

    LazyColumn(
            modifier = modifier
    ) {
        items(
                items = testList
        ) {
            test ->
            Card(
                    elevation = 12.dp,
                    backgroundColor = Color.LightGray,
                    modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 50.dp)
                            .width(40.dp)
                            .requiredHeight(intrinsicSize = IntrinsicSize.Min)
                            .padding(
                                    horizontal = 20.dp,
                                    vertical = 20.dp
                            )
                            .border(
                                    width = 1.dp,
                                    color = Color.Black,
                                    shape = RectangleShape
                            )
            ) {
                Row(
                        modifier = Modifier.fillMaxWidth()
                ) {

                    Icon(
                            modifier = Modifier
                                    .padding(horizontal = 5.dp)
                                    .align(Alignment.CenterVertically),
                            imageVector = Icons.Filled.Check,
                            contentDescription = null
                    )

                    Text(
                            text = test.title,
                            fontSize = 20.sp,
                            modifier =
                            Modifier
                                    .width(120.dp)
                                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    )

                    Text(
                            text = test.text,
                            fontSize = 20.sp,
                            modifier = Modifier
                                    .weight(1f) //it doesn't work!!
                                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CardRowSamplePreview() {

    CardRowSample()
}