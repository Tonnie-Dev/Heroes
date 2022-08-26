package com.uxstate.heroes.di

import com.uxstate.heroes.data.prefs.DataStoreOpsImpl
import com.uxstate.heroes.data.prefs.DataStoreOps
import com.uxstate.heroes.data.repository.HeroRepositoryImpl
import com.uxstate.heroes.domain.repository.HeroRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    //REPOSITORY
    @Binds //@Binds used for 1-to-1 interface-implementation mapping
    @Singleton

    /*The abstract function takes only a single parameter which
    is the interface implementation and the return type is the
    interface implemented by the given parameter object.*/

    abstract fun provideDataStoreOperations(dataStoreOperationsImpl:DataStoreOpsImpl): DataStoreOps

    abstract fun provideHeroRepository(heroRepositoryImpl: HeroRepositoryImpl):HeroRepository

}