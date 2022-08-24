package com.uxstate.heroes.domain.repository

import kotlinx.coroutines.flow.Flow


interface DataStoreOperations {

    suspend fun saveOnBoardingState(isCompleted:Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}