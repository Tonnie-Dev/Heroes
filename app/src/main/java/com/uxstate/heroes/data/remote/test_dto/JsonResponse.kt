package com.uxstate.heroes.data.remote.test_dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JsonResponse(
    @Json(name = "data")
    val data: List<Data>,
    @Json(name = "limit")
    val limit: Int,
    @Json(name = "page")
    val page: Int,
    @Json(name = "total")
    val total: Int
)