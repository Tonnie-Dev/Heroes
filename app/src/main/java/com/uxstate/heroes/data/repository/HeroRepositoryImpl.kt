package com.uxstate.heroes.data.repository

import androidx.paging.PagingData
import com.uxstate.heroes.domain.paging_source.RemoteDataSource
import com.uxstate.heroes.data.prefs.DataStoreOps
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.domain.repository.HeroRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//always depend on abstraction and not concretions
class HeroRepositoryImpl @Inject constructor(
    private val dataStoreOps: DataStoreOps,
    private val remoteDataSource: RemoteDataSource
) :
    HeroRepository {

    //private val dao = database.heroDao
    override suspend fun saveOnboardingState(isCompleted: Boolean) {
        dataStoreOps.saveOnBoardingState(isCompleted = isCompleted)
    }

    override fun readOnboardingStatus(): Flow<Boolean> {
        return dataStoreOps.readOnBoardingState()
    }

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
       return remoteDataSource.getAllHeroes()
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return remoteDataSource.searchHeroes(query)
    }


}