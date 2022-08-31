package com.uxstate.heroes.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.uxstate.heroes.data.local.HeroDatabase
import com.uxstate.heroes.data.remote.HeroAPI
import com.uxstate.heroes.domain.model.Hero
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class HeroRemoteMediator @Inject constructor(api:HeroAPI, database: HeroDatabase): RemoteMediator<Int, Hero>() {
    override suspend fun load(loadType: LoadType, state: PagingState<Int, Hero>): MediatorResult {
        TODO("Not yet implemented")
    }
}