package com.uxstate.heroes.data.remote.test_dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "firstName")
    val firstName: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "lastName")
    val lastName: String,
    @Json(name = "picture")
    val picture: String,
    @Json(name = "title")
    val title: String
)