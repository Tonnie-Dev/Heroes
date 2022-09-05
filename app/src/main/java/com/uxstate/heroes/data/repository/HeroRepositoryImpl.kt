package com.uxstate.heroes.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.uxstate.heroes.data.local.HeroDatabase
import com.uxstate.heroes.data.paging_source.HeroRemoteMediator
import com.uxstate.heroes.data.prefs.DataStoreOps
import com.uxstate.heroes.data.remote.HeroAPI
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.domain.repository.HeroRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//always depend on abstraction and not concretions
class HeroRepositoryImpl @Inject constructor(
    private val dataStoreOps: DataStoreOps,
    private val api: HeroAPI,
    private val database: HeroDatabase
) :
    HeroRepository {

    private val dao = database.heroDao
    override suspend fun saveOnboardingState(isCompleted: Boolean) {
        dataStoreOps.saveOnBoardingState(isCompleted = isCompleted)
    }

    override fun readOnboardingStatus(): Flow<Boolean> {
        return dataStoreOps.readOnBoardingState()
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun getAllData(): Flow<PagingData<Hero>> {


        /*This is the place where we are going to actually call the pager
        class and specify a paging config and PagingSource factory so that
        we can return a Flow*/

        //holds all cached data
        val pagingSourceFactory = {dao.getAllHeroes()}

        return Pager(
                config = PagingConfig(pageSize = 3),
                remoteMediator = HeroRemoteMediator(api =api, database =database),
                pagingSourceFactory = {dao.getAllHeroes()}
        ).flow
    }

    override fun searchHeroes(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }


}