package com.uxstate.heroes.di

import android.app.Application
import androidx.room.Room
import com.uxstate.heroes.data.local.HeroDatabase
import com.uxstate.heroes.util.Constants.HERO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton

    fun provideDatabase(app: Application): HeroDatabase {


        return Room.databaseBuilder(app, HeroDatabase::class.java, HERO_DATABASE)
                .build()
    }

}