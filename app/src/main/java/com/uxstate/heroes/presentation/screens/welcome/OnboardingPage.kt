package com.uxstate.heroes.presentation.screens.welcome

import androidx.annotation.DrawableRes
import com.uxstate.heroes.R

sealed class OnboardingPage(@DrawableRes image: Int, title: String, description: String){


    object FirstPage : OnboardingPage(R.drawable.greetings,"Greetings", "Are you a Boruto Fan? Because if you are we have great news for you!")
    object SecondPage : OnboardingPage(R.drawable.explore, "Explore", "Find your favorite heroes and learn some of the things that you didn't know about")
    object ThirdPage : OnboardingPage(R.drawable.power, "Power", "Find your favorite heroes and learn some of the things that you didn't know about")
}
