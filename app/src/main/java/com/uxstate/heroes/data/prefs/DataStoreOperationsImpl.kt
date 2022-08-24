package com.uxstate.heroes.data.prefs

import com.uxstate.heroes.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow

class DataStoreOperationsImpl:DataStoreOperations {
    override suspend fun saveOnBoardingState(isCompleted: Boolean) {
        TODO("Not yet implemented")
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        TODO("Not yet implemented")
    }
}