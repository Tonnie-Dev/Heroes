package com.uxstate.heroes.di

import android.app.Application
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.uxstate.heroes.data.local.HeroDatabase
import com.uxstate.heroes.data.remote.HeroAPI
import com.uxstate.heroes.domain.repository.HeroRepository
import com.uxstate.heroes.domain.use_cases.UseCaseWrapper
import com.uxstate.heroes.domain.use_cases.get_heroes.GetAllHeroesUseCase
import com.uxstate.heroes.domain.use_cases.read_onboarding.ReadOnboardingUseCase
import com.uxstate.heroes.domain.use_cases.save_onboarding.SaveOnboardingUseCase
import com.uxstate.heroes.util.Constants.HERO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
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
                saveOnboardingUseCase = SaveOnboardingUseCase(repository),
                getAllHeroesUseCase = GetAllHeroesUseCase(repository )
        )
    }



    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        /* connect timeout defines a time period in which our
     client should establish a connection with a target host.
By default, for the OkHttpClient, this timeout is set to 10 seconds.   */


        /*maximum time of inactivity between two data packets when waiting for the
        server's response.The default timeout of 10 seconds */


        return OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @Singleton
    fun provideHeroAPI(okHttpClient: OkHttpClient): HeroAPI {

        val moshi = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()

        return Retrofit.Builder()
                .baseUrl(HeroAPI.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create()
    }

}