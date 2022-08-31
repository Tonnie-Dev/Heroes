package com.uxstate.heroes.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uxstate.heroes.util.Constants.HERO_REMOTE_KEY_DATABASE_TABLE

/*Whenever we fetch some data from the API and in order to
paginate that data properly and cache it in a a local
database, then we need to use something that is called
the remote mediator

RemoteMediator will need to use remote keys in order to
paginate through data properly


In this table we going to store our ids from each and
every hero from the API and the previous and next page
associated with them.

Therefore Remote keys are the keys that the Remote-
mediator implementation uses to tell the to tell the
backend server which data to load next

The nullable Ints are so because the backend server
contains 5 different pages. The first page contains
a null previous page and the last page has a null
nextPage
*/


@Entity(tableName = HERO_REMOTE_KEY_DATABASE_TABLE)
data class HeroRemoteKeysEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextKey: Int?
)
