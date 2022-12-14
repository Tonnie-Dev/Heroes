package com.uxstate.heroes.domain.use_cases

import com.uxstate.heroes.domain.use_cases.get_heroes.GetAllHeroesUseCase
import com.uxstate.heroes.domain.use_cases.read_onboarding.ReadOnboardingUseCase
import com.uxstate.heroes.domain.use_cases.save_onboarding.SaveOnboardingUseCase
import com.uxstate.heroes.domain.use_cases.search_heroes.SearchHeroesUseCase

data class UseCaseWrapper(
    val readOnboardingUseCase: ReadOnboardingUseCase,
    val saveOnboardingUseCase: SaveOnboardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase,
    val searchHeroesUseCase: SearchHeroesUseCase
)