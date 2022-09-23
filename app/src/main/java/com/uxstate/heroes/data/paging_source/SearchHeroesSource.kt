package com.uxstate.heroes.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.uxstate.heroes.domain.model.Hero


/*We need to create our own PagingSource since we are not
* using ROOM*/
class SearchHeroesSource: PagingSource<Int, Hero>() {
    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {
        TODO("Not yet implemented")
    }
}