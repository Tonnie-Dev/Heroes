package com.uxstate.heroes.presentation.screens.welcome

import androidx.annotation.DrawableRes
import com.uxstate.heroes.R

sealed class OnboardingPage(@DrawableRes val image: Int, val title: String, val description: String){


    object FirstPage : OnboardingPage(R.drawable.greetings,"Greetings", "Are you a Boruto Fan? Because if you are we have great news for you!")
    object SecondPage : OnboardingPage(R.drawable.explore, "Explore", "Find your favorite heroes and learn some of the things that you didn't know about")
    object ThirdPage : OnboardingPage(R.drawable.power, "Power", "Check out your hero's power and see how much strong they are compared to others")
}
