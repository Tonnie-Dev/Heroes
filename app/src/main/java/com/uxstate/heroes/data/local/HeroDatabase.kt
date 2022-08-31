package com.uxstate.heroes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.uxstate.heroes.data.local.dao.HeroDao
import com.uxstate.heroes.data.local.dao.HeroRemoteKeyDao
import com.uxstate.heroes.data.local.entity.HeroEntity
import com.uxstate.heroes.data.local.entity.HeroRemoteKeysEntity

@Database(entities = [HeroEntity::class, HeroRemoteKeysEntity::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class HeroDatabase:RoomDatabase() {

    abstract val heroDao: HeroDao
    abstract val heroRemoteKeyDao:HeroRemoteKeyDao
}