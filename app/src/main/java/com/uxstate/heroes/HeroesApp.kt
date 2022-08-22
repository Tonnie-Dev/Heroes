package com.uxstate.heroes

import android.app.Application
import timber.log.Timber

class HeroesApp:Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}