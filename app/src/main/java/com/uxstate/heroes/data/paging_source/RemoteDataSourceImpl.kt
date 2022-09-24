package com.uxstate.heroes.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.uxstate.heroes.data.local.HeroDatabase
import com.uxstate.heroes.data.remote.HeroAPI
import com.uxstate.heroes.data.remote_mediator.HeroRemoteMediator
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.util.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val api: HeroAPI,
    private val database: HeroDatabase
) : RemoteDataSource {

    private val dao = database.heroDao

    @OptIn(ExperimentalPagingApi::class)
    override fun getAllHeroes(): Flow<PagingData<Hero>> {


        /*This is the place where we are going to actually call the pager
        class and specify a paging config and PagingSource factory so that
        we can return a Flow*/

        //holds all cached data - it is a function
        val pagingSourceFactory = { dao.getAllHeroes() }


        //Pager with 3 parameters constructor
        return Pager(
                config = PagingConfig(pageSize = Constants.ITEMS_PER_PAGE),
                remoteMediator = HeroRemoteMediator(api = api, database = database),
                pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {

        //Pager with 2 parameters constructor
        return Pager(
                config = PagingConfig(pageSize = Constants.ITEMS_PER_PAGE),
                pagingSourceFactory = { SearchHeroesSource(api = api, query = query) }).flow
    }
}