package com.uxstate.heroes.data.prefs

import kotlinx.coroutines.flow.Flow


interface DataStoreOps {


    //2 functions to interact with DataStore
    suspend fun saveOnBoardingState(isCompleted: Boolean)
    fun readOnBoardingState(): Flow<Boolean>

}




