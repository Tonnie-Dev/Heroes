package com.uxstate.heroes.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.uxstate.heroes.domain.model.Hero

@OptIn(ExperimentalPagingApi::class)
class HeroRemoteMediator: RemoteMediator<Int, Hero>() {
    override suspend fun load(loadType: LoadType, state: PagingState<Int, Hero>): MediatorResult {
        TODO("Not yet implemented")
    }
}