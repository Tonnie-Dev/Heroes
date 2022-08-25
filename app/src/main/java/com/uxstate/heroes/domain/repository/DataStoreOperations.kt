package com.uxstate.heroes.domain.repository

import kotlinx.coroutines.flow.Flow


interface DataStoreOperations {


    //2 functions to interact with DataStore
    suspend fun saveOnBoardingState(isCompleted: Boolean)
    fun readOnBoardingState(): Flow<Boolean>

}




