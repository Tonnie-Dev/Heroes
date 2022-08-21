package com.uxstate.heroes.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uxstate.heroes.util.Constants.HERO_DATABASE_TABLE

@Entity(tableName = HERO_DATABASE_TABLE)
data class HeroEntity(

    //each hero on the server has a unique id
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val month: String,
    val day: String,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>
)