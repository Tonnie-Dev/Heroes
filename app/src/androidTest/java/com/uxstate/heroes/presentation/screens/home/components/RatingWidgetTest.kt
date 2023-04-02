package com.uxstate.heroes.presentation.screens.home.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import com.uxstate.heroes.presentation.ui.theme.SMALL_PADDING

class RatingWidgetTest {


    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun passZeroPointZeroValue_Assert_FiveEmptyStars(){
        
        composeTestRule.setContent { 
            RatingWidget(modifier = Modifier.padding(all = SMALL_PADDING), rating = 0.0)
        }

    }
}