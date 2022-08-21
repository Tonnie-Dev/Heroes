package com.uxstate.heroes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uxstate.heroes.data.local.dao.HeroDao
import com.uxstate.heroes.data.local.dao.HeroRemoteKeyDao
import com.uxstate.heroes.data.local.entity.HeroEntity
import com.uxstate.heroes.data.local.entity.HeroRemoteKeyEntity

@Database(entities = [HeroEntity::class, HeroRemoteKeyEntity::class], version = 1)
abstract class HeroDatabase:RoomDatabase() {

    abstract val heroDao: HeroDao
    abstract val heroRemoteKeyDao:HeroRemoteKeyDao
}