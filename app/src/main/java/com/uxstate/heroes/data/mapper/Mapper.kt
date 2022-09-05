package com.uxstate.heroes.data.mapper

import com.uxstate.heroes.data.local.entity.HeroEntity
import com.uxstate.heroes.data.local.entity.HeroRemoteKeysEntity
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.domain.model.HeroRemoteKeys

//HeroEntity to Hero
fun HeroEntity.toModel():Hero {

    return Hero(
            id = this.id,
            name = this.name,
            image =this.image,
            about = this.about,
            rating = this.rating,
            power = this.power,
            month = this.month,
            day = this.day,
            family = this.family,
            abilities = this.abilities,
            natureTypes = this.natureTypes
    )
}
//Hero to HeroEntity
fun Hero.toEntity(): HeroEntity {

    return HeroEntity(
            id = this.id,
            name = this.name,
            image =this.image,
            about = this.about,
            rating = this.rating,
            power = this.power,
            month = this.month,
            day = this.day,
            family = this.family,
            abilities = this.abilities,
            natureTypes = this.natureTypes
    )
}
//HeroRemoteKeys to HeroRemoteKeysEntity
fun HeroRemoteKeys.toEntity(): HeroRemoteKeysEntity {

    return HeroRemoteKeysEntity(
            id = this.id,
            prevPage = this.prevPage,
            nextKey = this.nextPage
    )
}

//HeroRemoteKeysEntity to HeroRemoteKeys

fun HeroRemoteKeysEntity.toModel(): HeroRemoteKeys{

    return HeroRemoteKeys(
            id = this.id,
            prevPage = this.prevPage,
            nextPage = this.nextKey
    )
}