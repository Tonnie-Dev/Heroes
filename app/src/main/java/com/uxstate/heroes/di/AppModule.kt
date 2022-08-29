package com.uxstate.heroes.di

import android.app.Application
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.uxstate.heroes.data.local.HeroDatabase
import com.uxstate.heroes.data.remote.HeroAPI
import com.uxstate.heroes.domain.repository.HeroRepository
import com.uxstate.heroes.domain.use_cases.UseCaseWrapper
import com.uxstate.heroes.domain.use_cases.read_onboarding.ReadOnboardingUseCase
import com.uxstate.heroes.domain.use_cases.save_onboarding.SaveOnboardingUseCase
import com.uxstate.heroes.util.Constants.HERO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
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

    @Provides
    @Singleton
    fun provideUseCaseWrapperClass(repository: HeroRepository): UseCaseWrapper {


        return UseCaseWrapper(
                readOnboardingUseCase = ReadOnboardingUseCase(repository),
                saveOnboardingUseCase = SaveOnboardingUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideHeroAPI(): HeroAPI {

        val moshi = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()

        return Retrofit.Builder()
                .baseUrl(HeroAPI.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create()
    }

}