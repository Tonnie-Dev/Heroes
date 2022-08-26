package com.uxstate.heroes.data.repository

import com.uxstate.heroes.data.prefs.DataStoreOperations
import com.uxstate.heroes.domain.repository.HeroRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//always depend on abstraction and not concretions
class HeroRepositoryImpl @Inject constructor(private val dataStoreOperations: DataStoreOperations) :
    HeroRepository {
    override suspend fun saveOnboardingState(isCompleted: Boolean) {
        dataStoreOperations.saveOnBoardingState(isCompleted = isCompleted)
    }

    override fun readOnboardingStatus(): Flow<Boolean> {
        return dataStoreOperations.readOnBoardingState()
    }


}