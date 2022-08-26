package com.uxstate.heroes.domain.use_cases.read_onboarding

import com.uxstate.heroes.domain.repository.HeroRepository
import kotlinx.coroutines.flow.Flow

class ReadOnboardingUseCase(private val repository: HeroRepository) {

operator fun invoke(): Flow<Boolean> {

    return repository.readOnboardingStatus()
}
}