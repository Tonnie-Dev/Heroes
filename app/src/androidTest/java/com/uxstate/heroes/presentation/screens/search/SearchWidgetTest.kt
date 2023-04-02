package com.uxstate.heroes.presentation.screens.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
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
        //trigger UI Operation from outside the setContent block
        composeTestRule.onNodeWithContentDescription("TextField")
                .performTextInput("Tonnie")

        //Assert
        composeTestRule.onNodeWithContentDescription("TextField")
                .assertTextEquals("Tonnie")
    }

    @Test
    fun openSearchWidget_inputText_pressClearTextTrailingIconOnce_assertEmptyText() {
        //observable text variable
        var text by mutableStateOf("")

        composeTestRule.setContent {
            //initialize search widget
            SearchWidget(text = text, onTextChange = { text = it }, onSearch = {}, onClose = { })
        }
        // Perform actions and assertions

        composeTestRule.onNodeWithContentDescription("TextField")
                .performTextInput("Tonnie")
        composeTestRule.onNodeWithContentDescription("CloseIcon")
                .performClick()

        composeTestRule.onNodeWithContentDescription("TextField")
                .assertTextContains("")
    }

    @Test
    fun openSearchWidget_addInputText_pressCloseButtonTwice_assertClosedState() {
        var text by mutableStateOf("")
        var isSearchWidgetShown by mutableStateOf(true)

        composeTestRule.setContent {

            if (isSearchWidgetShown) {

                //initialize search widget
                SearchWidget(
                        text = text, onTextChange = { text = it }, onSearch = {},
                        //whenever onClose is triggered you negate isSearchWidgetShown
                        onClose = { isSearchWidgetShown = false }
                )
            }}

            composeTestRule.onNodeWithContentDescription("TextField")
                    .performTextInput("tonnie")

            //to clear text
            composeTestRule.onNodeWithContentDescription("CloseIcon")
                    .performClick()
            //to close the widget
            composeTestRule.onNodeWithContentDescription("CloseIcon")
                    .performClick()

            composeTestRule.onNodeWithContentDescription("SearchWidget")
                    .assertDoesNotExist()

    }

    @Test
    fun openSearchWidget_PressCloseButtonOnceWithEmptyText_assertClosedState(){
        var isSearchWidgetShown by mutableStateOf(true)

        composeTestRule.setContent {

            if (isSearchWidgetShown) {
                SearchWidget(text = "",
                        onTextChange = {},
                        onSearch = {},
                        onClose = { isSearchWidgetShown = false })

            }
        }
        composeTestRule.onNodeWithContentDescription("CloseIcon")
                .performClick()
        composeTestRule.onNodeWithContentDescription("SearchWidget")
                .assertDoesNotExist()
    }
}