package com.uxstate.heroes.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.domain.repository.HeroRepository
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(private val repository: HeroRepository) {

    operator fun invoke(query:String): Flow<PagingData<Hero>> {


        return repository.searchHeroes(query)
    }
}