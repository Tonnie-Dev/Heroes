package com.uxstate.heroes.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.uxstate.heroes.domain.model.Hero


@JsonClass(generateAdapter = true)
data class ApiResponseDTO(
    @Json(name = "success")
    val success: Boolean,
    @Json(name = "message")
    val message: String?,
    @Json(name = "nextPage")
    val nextPage: Int?,
    @Json(name = "previousPage")
    val prevPage: Int?,
    @Json(name = "heroes")
    val heroes: List<Hero>,
    @Json(name = "lastUpdated")
    val lastUpdated: Long?,

)
