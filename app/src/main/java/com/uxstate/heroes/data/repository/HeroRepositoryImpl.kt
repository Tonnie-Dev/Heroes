package com.uxstate.heroes.data.repository

import com.uxstate.heroes.data.prefs.DataStoreOps
import com.uxstate.heroes.domain.repository.HeroRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//always depend on abstraction and not concretions
class HeroRepositoryImpl @Inject constructor(private val dataStoreOps: DataStoreOps) :
    HeroRepository {
    override suspend fun saveOnboardingState(isCompleted: Boolean) {
        dataStoreOps.saveOnBoardingState(isCompleted = isCompleted)
    }

    override fun readOnboardingStatus(): Flow<Boolean> {
        return dataStoreOps.readOnBoardingState()
    }


}