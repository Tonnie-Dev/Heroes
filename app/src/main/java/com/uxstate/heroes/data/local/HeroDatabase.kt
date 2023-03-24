package com.uxstate.heroes.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.uxstate.heroes.data.local.dao.HeroDao
import com.uxstate.heroes.data.local.dao.HeroRemoteKeysDao
import com.uxstate.heroes.data.local.entity.HeroEntity
import com.uxstate.heroes.data.local.entity.HeroRemoteKeysEntity

@Database(entities = [HeroEntity::class, HeroRemoteKeysEntity::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class HeroDatabase : RoomDatabase() {

    companion object {

       /* RoomDatabase.Builder for a persistent database.
Creates a RoomDatabase.Builder for an in memory database.
Information stored in an in memory database disappears when the process is killed
       * */

        fun create(context: Context, useInMemory: Boolean): HeroDatabase {

            val databaseBuilder = if (useInMemory) {
                Room.inMemoryDatabaseBuilder(context, HeroDatabase::class.java)
            } else {
                Room.databaseBuilder(context, HeroDatabase::class.java, "test_database.db")
            }

            return databaseBuilder.fallbackToDestructiveMigration()
                    .build()
        }
    }

    abstract val heroDao: HeroDao
    abstract val heroRemoteKeysDao: HeroRemoteKeysDao
}