package com.uxstate.heroes.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.uxstate.heroes.data.remote.HeroAPI
import com.uxstate.heroes.domain.model.Hero
import javax.inject.Inject


/*We need to create our own PagingSource since we are not
* using ROOM*/
class SearchHeroesSource @Inject constructor(
    private val api: HeroAPI,
    private val query: String
) : PagingSource<Int, Hero>() {

    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        return state.anchorPosition

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {
        return try {

            val apiResponse = api.searchHeroes(name = query)
            val heroes = apiResponse.heroes

            if (heroes.isNotEmpty()) {

                LoadResult.Page(
                        data = heroes,
                        prevKey = apiResponse.prevPage,
                        nextKey = apiResponse.nextPage
                )
            } else {

                LoadResult.Page(
                        data = emptyList(),
                        prevKey = null,
                        nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)

        }
    }
}