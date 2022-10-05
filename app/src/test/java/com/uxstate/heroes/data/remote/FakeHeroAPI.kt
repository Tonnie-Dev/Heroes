package com.uxstate.heroes.data.remote

import com.uxstate.heroes.data.remote.dto.ApiResponseDTO

class FakeHeroAPI: HeroAPI {
    override suspend fun getAllHeroes(page: Int): ApiResponseDTO {

        //we will not implement this so we return a blank API
        return ApiResponseDTO(success = false)
    }

    override suspend fun searchHeroes(name: String): ApiResponseDTO {
        TODO("Not yet implemented")
    }
}