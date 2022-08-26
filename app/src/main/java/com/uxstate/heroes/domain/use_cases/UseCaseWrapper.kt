package com.uxstate.heroes.domain.use_cases

import com.uxstate.heroes.domain.use_cases.read_onboarding.ReadOnboardingUseCase
import com.uxstate.heroes.domain.use_cases.save_onboarding.SaveOnboardingUseCase

data class UseCaseWrapper(
    val readOnboardingUseCase: ReadOnboardingUseCase,
    val saveOnboardingUseCase: SaveOnboardingUseCase
)