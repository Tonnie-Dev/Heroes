package com.uxstate.heroes.presentation.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LightGray = Color(0xFFD8D8D8)
val DarkGray = Color(0xFF2A2A2A)


//extension variable on MaterialTheme.colors

/*We will be able to access this color variable through the
 material object*/

val Colors.welcomeScreenBackgroundColor

    get() = if (this.isLight) Color.White else Color.Black //composable getter function

val Colors.titleColor
    @Composable
    get() = if (isLight) DarkGray else LightGray

val Colors.descriptionColor
    @Composable
    get() = if (isLight) DarkGray.copy(alpha = 0.5f)
    else LightGray.copy(alpha = 0.5f)



val Colors.activeColorIndicator
get() = if (this.isLight) Purple500 else Purple700


val Colors.inactiveColorIndicator
get() = if (this.isLight) LightGray else DarkGray


val Colors.buttonBackgroundColor
get() = if (this.isLight) Purple700 else Purple500