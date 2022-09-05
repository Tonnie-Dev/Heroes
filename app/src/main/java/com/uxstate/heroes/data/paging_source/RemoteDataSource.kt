package com.uxstate.heroes.data.paging_source

import androidx.paging.PagingData
import com.uxstate.heroes.domain.model.Hero
import kotlinx.coroutines.flow.Flow


interface RemoteDataSource {

    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes():Flow<PagingData<Hero>>
}