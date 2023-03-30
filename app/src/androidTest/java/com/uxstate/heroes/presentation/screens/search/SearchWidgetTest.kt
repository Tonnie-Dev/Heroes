package com.uxstate.heroes.presentation.screens.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performTextInput
import com.uxstate.heroes.presentation.screens.search.components.SearchWidget
import org.junit.Rule
import org.junit.Test

class SearchWidgetTest {

    //This is to allow us call composable functions
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun openSearchWidget_enterInputText_assertInputText() {
        var text by mutableStateOf("")
        //use composeTestRule to set up compose environment
        composeTestRule.setContent {
            //we can call composables here

            //initialize search widget
            SearchWidget(text = text, onTextChange = { text = it }, onSearch = {}, onClose = { })

        }

        //trigger UI Operation
        composeTestRule.onNodeWithContentDescription("TextField")
                .performTextInput("Tonnie")

        //Assert
        composeTestRule.onNodeWithContentDescription("TextField")
                .assertTextEquals("Tonnie")
    }
}