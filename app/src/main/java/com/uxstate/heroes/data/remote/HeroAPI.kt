package com.uxstate.heroes.data.remote

import com.uxstate.heroes.data.remote.dto.ApiResponseDTO

import com.uxstate.heroes.domain.model.Hero
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroAPI {
    @GET("boruto/heroes")
    suspend fun getAllHeroes(@Query("page") page:Int = 1):ApiResponseDTO
    @GET("boruto/heroes/search")
    suspend fun searchHeroes(@Query("name") name: String):ApiResponseDTO

}