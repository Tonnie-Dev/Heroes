package com.uxstate.heroes.domain.repository

import androidx.paging.PagingData
import com.uxstate.heroes.domain.model.Hero
import kotlinx.coroutines.flow.Flow


interface HeroRepository {

    suspend fun saveOnboardingState(isCompleted:Boolean)
    fun readOnboardingStatus(): Flow<Boolean>
    fun getAllData():Flow<PagingData<Hero>>
    fun searchHeroes():Flow<PagingData<Hero>>
}