package com.uxstate.heroes.domain.repository

import kotlinx.coroutines.flow.Flow


interface HeroRepository {

    suspend fun saveOnboardingState(isCompleted:Boolean)
    fun readOnboardingStatus(): Flow<Boolean>
}