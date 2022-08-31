package com.uxstate.heroes.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uxstate.heroes.data.local.entity.HeroRemoteKeysEntity

@Dao
interface HeroRemoteKeysDao {

    //get specific remote key

    @Query("SELECT * FROM hero_remote_keys_table WHERE id=:id")
    suspend fun getRemoteKeys(id:Int):HeroRemoteKeysEntity?

    //add all remote keys to the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllKeys(heroRemoteKeys:List<HeroRemoteKeysEntity>)


    //remove all remote keys
    @Query("DELETE FROM hero_remote_keys_table")
    suspend fun deleteAllRemoteKeys()
}