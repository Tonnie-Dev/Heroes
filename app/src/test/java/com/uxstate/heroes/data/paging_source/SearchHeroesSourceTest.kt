package com.uxstate.heroes.data.paging_source

import com.uxstate.heroes.data.remote.FakeHeroAPI
import com.uxstate.heroes.data.remote.HeroAPI
import com.uxstate.heroes.domain.model.Hero
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class SearchHeroesSourceTest {

    private lateinit var api: HeroAPI
    private lateinit var heroes: List<Hero>

    @Before
    fun setUp() {

        api = FakeHeroAPI()
        val heroes = listOf<Hero>(
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
        runBlocking {
val heroSource = SearchHeroesSource(api = api, query = "Sasuke")


        }
}