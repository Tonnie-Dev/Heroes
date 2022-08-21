package com.uxstate.heroes.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uxstate.heroes.data.local.entity.HeroRemoteKeyEntity

interface HeroRemoteKeyDao {

    //get specific remote key

    @Query("SELECT * FROM hero_remote_key_table WHERE id=:id")
    suspend fun getRemoteKey(id:Int):HeroRemoteKeyEntity?

    //add all remote keys to the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllKeys(heroRemoteKeys:List<HeroRemoteKeyEntity>)


    //remove all remote keys
    @Query("DELETE FROM hero_remote_key_table")
    suspend fun deleteAllRemoteKeys()
}