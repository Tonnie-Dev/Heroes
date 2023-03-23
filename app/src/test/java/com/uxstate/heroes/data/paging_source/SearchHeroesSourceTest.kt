package com.uxstate.heroes.data.paging_source

import androidx.paging.PagingSource
import com.uxstate.heroes.data.remote.FakeHeroAPI
import com.uxstate.heroes.data.remote.HeroAPI
import com.uxstate.heroes.domain.model.Hero
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SearchHeroesSourceTest {

    private lateinit var api: HeroAPI
    private lateinit var heroes: List<Hero>

    @Before
    fun setUp() {

        api = FakeHeroAPI()

        //to be used in the expected context
        heroes = listOf(
                Hero(
                        id = 1,
                        name = "Sasuke",
                        image = "",
                        about = "",
                        rating = 4.1,
                        power = 0,
                        month = "",
                        day = "",
                        family = listOf(),
                        abilities = listOf(),
                        natureTypes = listOf()
                ),
                Hero(
                        id = 2,
                        name = "Naruto",
                        image = "",
                        about = "",
                        rating = 3.9,
                        power = 0,
                        month = "",
                        day = "",
                        family = listOf(),
                        abilities = listOf(),
                        natureTypes = listOf()
                ),

                Hero(
                        id = 3,
                        name = "Sakura",
                        image = "",
                        about = "",
                        rating = 3.0,
                        power = 0,
                        month = "",
                        day = "",
                        family = listOf(),
                        abilities = listOf(),
                        natureTypes = listOf()
                )

        )
    }

    @Test
    fun `Search api with an existing hero name, expect single hero result, assert LoadResult_Page`() =

        //we are testing PagingSource's load() function which is suspending
        runBlocking {
            val heroPagingSource = SearchHeroesSource(api = api, query = "Sasuke")

            assertEquals<PagingSource.LoadResult<Int, Hero>>(
                    expected = PagingSource.LoadResult.Page(
                            data = listOf(heroes.first()),
                            prevKey = null,
                            nextKey = null
                    ),

                    //heroPagingSource.load() is a suspend function therefore use run blocking
                    actual = heroPagingSource.load(
                            PagingSource.LoadParams.Refresh(
                                    key = null,
                                    loadSize = 3,
                                    placeholdersEnabled = false
                            )
                    )
            )
        }


    @Test
    fun `Search with a keyword, expect multiple heroes, assert LoadResult_Page`() = runBlocking {

        val source = SearchHeroesSource(api = api, query = "u")
        assertEquals<PagingSource.LoadResult<Int, Hero>>(
                expected = PagingSource.LoadResult.Page(
                        data = heroes,
                        prevKey = null,
                        nextKey = null
                ),
                actual = source.load(
                        params = PagingSource.LoadParams.Refresh(
                                key = null,
                                loadSize = 3,
                                placeholdersEnabled = false
                        )
                )
        )

    }

    @Test
    fun `Search with an empty hero name, expect an empty heroes list, assert LoadResult_Page`() =
        runBlocking {

            //first establish source to return LoadResult.Page
            val source = SearchHeroesSource(api = api, query = "")
            assertEquals<PagingSource.LoadResult<Int, Hero>>(
                    expected = PagingSource.LoadResult.Page(
                            data = emptyList(),
                            prevKey = null,
                            nextKey = null
                    ),

                    actual = source.load(
                            params = PagingSource.LoadParams.Refresh(
                                    key = null,
                                    loadSize = 3,
                                    placeholdersEnabled = false
                            )
                    )
            )
        }

    @Test
    fun `Search with an empty hero name, expect an empty list, assert LoadResult_Page`() =
        runBlocking {

            val source = SearchHeroesSource(api = api, query = "")
            val loadingResult = source.load(
                    PagingSource.LoadParams.Refresh(
                            key = null,
                            loadSize = 3,
                            placeholdersEnabled = false
                    )
            )

            //API request as we are unable to extract the returned list just from loadingResults
            val response = api.searchHeroes("").heroes

            assertTrue(actual = response.isEmpty())
            assertTrue{loadingResult is PagingSource.LoadResult.Page}

        }
}