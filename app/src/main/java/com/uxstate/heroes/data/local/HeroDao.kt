package com.uxstate.heroes.data.local

import androidx.paging.PagingSource
import androidx.room.Query
import com.uxstate.heroes.domain.model.Hero

interface HeroDao {

    @Query("SELECT * FROM hero_table ORDER BY id ASC")
    fun getAllHeroes(): PagingSource<Int, Hero>
}