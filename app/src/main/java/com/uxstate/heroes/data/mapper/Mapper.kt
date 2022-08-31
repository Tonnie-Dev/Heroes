package com.uxstate.heroes.data.mapper

import com.uxstate.heroes.domain.model.HeroRemoteKeys

//HeroRemoteKeys to HeroRemoteKeysEntity

fun HeroRemoteKeys.toEntity(): HeroRemoteKeys {

    return HeroRemoteKeys(
            id = this.id,
            prevPage = this.prevPage,
            nextKey = this.nextKey
    )
}