package com.uxstate.heroes.data.remote

import com.uxstate.heroes.data.remote.dto.ApiResponseDTO
import com.uxstate.heroes.domain.model.Hero

/*This class will fake the result from the server*/
class FakeHeroAPI : HeroAPI {
    //random heroes
    private val heroes = listOf(
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

        //we will not test/implement this so we return a blank DTO
        return ApiResponseDTO(success = false, heroes = heroes)
    }

    override suspend fun searchHeroes(name: String): ApiResponseDTO {
        val foundHero = findHero(name = name)

        return ApiResponseDTO(success = true, message = "OK", heroes = foundHero)
    }

    private fun findHero(name: String): List<Hero> {
        val foundHero = mutableListOf<Hero>()
        return if (name.isNotEmpty()) {

            for (hero in heroes) {

                if (hero.name.lowercase().contains(name, true)) {
                    foundHero.add(hero)
                }

            }
            foundHero
        } else emptyList()


    }


}