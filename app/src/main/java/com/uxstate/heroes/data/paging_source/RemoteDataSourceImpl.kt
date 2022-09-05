package com.uxstate.heroes.data.paging_source

import androidx.paging.PagingData
import com.uxstate.heroes.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImpl:RemoteDataSource {
    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }

    override fun searchHeroes(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }
}