package com.uxstate.heroes.domain.use_cases.save_onboarding

import com.uxstate.heroes.domain.repository.HeroRepository

class SaveOnboardingUseCase(private val repository: HeroRepository) {


    suspend operator fun invoke(isCompleted:Boolean){

        repository.saveOnboardingState(isCompleted)
    }
}