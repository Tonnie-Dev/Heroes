package com.uxstate.heroes.data.remote

import com.uxstate.heroes.data.remote.dto.ApiResponseDTO
import com.uxstate.heroes.domain.model.Hero

/*This class will fake the result from the server*/
class FakeHeroAPI : HeroAPI {

    private val heroes = listOf<Hero>(
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

    override suspend fun getAllHeroes(page: Int): ApiResponseDTO {

        //we will not implement this so we return a blank API
        return ApiResponseDTO(success = false)
    }

    override suspend fun searchHeroes(name: String): ApiResponseDTO {
        TODO("Not yet implemented")
    }

    private fun findHero(name: String): List<Hero> {
        val foundHero = mutableListOf<Hero>()
        return if (name.isNotEmpty()) {

            for (hero in heroes) {

                if (hero.name.contains(name, true)) {
                    foundHero.add(hero)
                }

            }
            foundHero
        } else emptyList()


    }


}