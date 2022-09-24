package com.uxstate.heroes.presentation.screens.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.domain.use_cases.UseCaseWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(private val useCaseWrapper: UseCaseWrapper) : ViewModel() {

    var searchQuery by mutableStateOf("")
    private set


    private val _searchedHeroes = MutableStateFlow<PagingData<Hero>>(value = PagingData.empty())
    //backing field for _searchedHeroes
    val searchedHeroes = _searchedHeroes

   fun updateSearchQuery(query:String){

       searchQuery = query
   }

    fun searchedHeroes(query: String){

        //use viewModelScope because collect{} is a suspend function

        viewModelScope.launch {
            //useCaseWrapper.searchHeroesUseCase returns Flow<PagingData<Hero>>
            useCaseWrapper.searchHeroesUseCase(query = query)


                    /*
                    Cache useCaseWrapper. searchHeroesUseCase result in this vModel

                    Caches the PagingData such that any downstream collection from this
                    flow will share the same PagingData.

                    The flow is kept active as long as the given scope is active. To avoid
                    leaks, make sure to use a scope that is already managed (like a ViewModel
                    scope) or manually cancel it when you don't need paging anymore.
                    */
                    .cachedIn(viewModelScope).collect{

                _searchedHeroes.value = it
            }

        }


    }

}
