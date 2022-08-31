package com.uxstate.heroes.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.uxstate.heroes.data.local.HeroDatabase
import com.uxstate.heroes.data.remote.HeroAPI
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.domain.model.HeroRemoteKeys
import javax.inject.Inject


/*query is a simple string which define which data
 retrieve from the backend server*/
@OptIn(ExperimentalPagingApi::class)
class HeroRemoteMediator @Inject constructor(
    private val api: HeroAPI,
    private val database: HeroDatabase
) : RemoteMediator<Int, Hero>() {

    //get daos
    private val heroDao = database.heroDao
    private val heroRemoteKeysDao = database.heroRemoteKeysDao

    /*responsible for updating the backing dataset and invalidating the paging source*/
    override suspend fun load(loadType: LoadType, state: PagingState<Int, Hero>): MediatorResult {
        try {

            val response = api.getAllHeroes()
            //check the heroes list from api is not empty
            if (response.heroes.isNotEmpty()) {

                //if not empty save items into database

                database.withTransaction {

                    /* LoadType.Refresh is triggered the 1st time app is installed
                    * or when the data is invalidated*/


                    if (loadType == LoadType.REFRESH) {

                        //clear tables
                        heroDao.deleteAllHeroes()
                        heroRemoteKeysDao.deleteAllRemoteKeys()

                    }

                    val prevPage = response.prevPage
                    val nextPage = response.nextPage

                    //retrieve ids from heroes
                    val keys = response.heroes.map {
                        HeroRemoteKeys(
                                id = it.id,
                                prevPage = prevPage,
                                nextKey = nextPage
                        )


                    }

                    //Add keys into database
                    heroRemoteKeysDao.addAllKeys(keys)

                }

            }
        } catch (e: Exception) {

            return MediatorResult.Error(e)
        }


    }

}