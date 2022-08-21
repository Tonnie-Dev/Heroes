package com.uxstate.heroes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HeroEntity::class], version = 1)
abstract class HeroDatabase:RoomDatabase() {

    abstract val dao:HeroDao
}