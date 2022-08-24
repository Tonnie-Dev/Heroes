package com.uxstate.heroes.domain.repository

interface DataStoreOperations {

    suspend fun saveOnBoardingState(isCompleted:Boolean)
}