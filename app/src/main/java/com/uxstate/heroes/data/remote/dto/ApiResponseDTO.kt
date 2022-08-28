package com.uxstate.heroes.data.remote.dto

import com.uxstate.heroes.domain.model.Hero

data class ApiResponseDTO( val success: Boolean,
                           val message: String? = null,
                           val prevPage: Int? = null,
                           val nextPage: Int? = null,
                           val heroes: List<Hero> = emptyList())
