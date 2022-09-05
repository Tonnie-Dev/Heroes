package com.uxstate.heroes.domain.use_cases.get_heroes

import androidx.paging.PagingData
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.domain.repository.HeroRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllHeroesUseCase(private val repository: HeroRepository) {


    operator fun invoke(): Flow<PagingData<Hero>>{


        return repository.getAllHeroes()
    }
}