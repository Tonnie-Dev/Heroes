package com.uxstate.heroes.data.remote

import com.uxstate.heroes.domain.model.ApiResponse
import com.uxstate.heroes.domain.model.Hero
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroAPI {

    @GET("/boruto/heroes/search")
    fun searchHero(@Query("name") name: String):List<Hero>

    @GET("boruto/heroes")
    fun getAllHeroes(@Query("page") page:Int):ApiResponse
}