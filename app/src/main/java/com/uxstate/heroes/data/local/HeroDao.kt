package com.uxstate.heroes.data.local

import androidx.paging.PagingSource
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uxstate.heroes.domain.model.Hero

interface HeroDao {
/*The key represents the actual page number, hero will be the actual
 object which we want to receive from ROOM Database

 PagingSource is the base class for Asynchronous loading of snapshots
 of data.

 By default the ROOM database supports paging 3 library we that we can
 easily use paginated queries

 To retrieve data from the database in a paginated way is to set a
 paging source as the return type of that function. i.e. we will get
 our items from the database page by page

*/
    @Query("SELECT * FROM hero_table ORDER BY id ASC")
    fun getAllHeroes(): PagingSource<Int, Hero>


    @Query("SELECT * FROM hero_table WHERE id=:id")
    fun getSelectedHero(id:Int):Hero


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHeroes(heroes:List<Hero>)


    @Query("DELETE FROM hero_table")
    suspend fun deleteAllHeroes()
}