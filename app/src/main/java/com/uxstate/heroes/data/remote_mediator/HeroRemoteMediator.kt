package com.uxstate.heroes.data.remote_mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.uxstate.heroes.data.local.HeroDatabase
import com.uxstate.heroes.data.mapper.toEntity
import com.uxstate.heroes.data.mapper.toModel
import com.uxstate.heroes.data.remote.HeroAPI
import com.uxstate.heroes.domain.model.Hero
import com.uxstate.heroes.domain.model.HeroRemoteKeys
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
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


    override suspend fun initialize(): InitializeAction {
        //get current time when initialize() is triggered
        val currentTime = System.currentTimeMillis()

        //pass an arbitrary id
        val lastUpdate = heroRemoteKeysDao.getRemoteKeys(1)?.lastUpdated ?: 0L

        val cacheTimeout = 1440

        Timber.i("Mediator: Current Time ${parseMillis(currentTime)}")
        Timber.i("Mediator: Last Updated Time ${parseMillis(lastUpdate)}")

        //divide by 1000 to get secs and 60 to get minutes
        val diffInMinutes = (currentTime - lastUpdate)/1000/60

        return if (diffInMinutes.toInt() <= cacheTimeout){
            Timber.i("Mediator: UP TO DATE")
            //load from the database
            InitializeAction.SKIP_INITIAL_REFRESH


        }else{

            Timber.i ("Mediator: REFRESH")
            InitializeAction.LAUNCH_INITIAL_REFRESH

        }


    }

    /*responsible for updating the backing dataset and invalidating the paging source*/
    override suspend fun load(loadType: LoadType, state: PagingState<Int, Hero>): MediatorResult {
        return try {


            val page = when (loadType) {
                //is over enum entry is not allowed


                /*PagingData content being refreshed, which can be a result of
                PagingSource invalidation, refresh that may contain content
                updates, or the initial load.*/

                LoadType.REFRESH -> {

                    val remoteKeys = getRemoteKeyClosetToCurrentPosition(state = state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }

                /*Load at the start of a PagingData. i.e. load from the db*/
                LoadType.PREPEND -> {

                    val remoteKeys = getRemoteKeyForFirstItem(state = state)
                    val prevPage = remoteKeys?.prevPage ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                    )
                    prevPage
                }

                /*Load at the end of a PagingData.*/
                LoadType.APPEND -> {

                    val remoteKeys = getRemoteKeyForLastItem(state)

                    //this return refers to return on try-catch block
                    val nextPage = remoteKeys?.nextPage ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                    )
                    nextPage
                }

            }
            //Make API response
            val response = api.getAllHeroes(page = page)

            //check the heroes list from api is not empty
            if (response.heroes.isNotEmpty()) {

                //if not empty save items into database

                database.withTransaction {

                    /* LoadType.Refresh is triggered the 1st time app is installed
                   or when the data is invalidated*/
                    if (loadType == LoadType.REFRESH) {
                        //clear tables
                        heroDao.deleteAllHeroes()
                        heroRemoteKeysDao.deleteAllRemoteKeys()
                    }

                    //extract pages values to enable saving the HeroRemoteKeys
                    val prevPage = response.prevPage
                    val nextPage = response.nextPage

                    //retrieve ids from heroes
                    val keys = response.heroes.map {
                        HeroRemoteKeys(
                                id = it.id,
                                prevPage = prevPage,
                                nextPage = nextPage,
                                lastUpdated =response.lastUpdated
                        )
                    }

                    //populate keys into database
                    heroRemoteKeysDao.addAllKeys(keys.map { it.toEntity() })

                    //populate heroes into database from the server
                    heroDao.addHeroes(response.heroes.map { it.toEntity() })

                }


            }

            //return success passing boolean to signal end of page
            MediatorResult.Success(endOfPaginationReached = response.nextPage == null)
        } catch (e: Exception) {

            return MediatorResult.Error(e)
        }


    }


    private suspend fun getRemoteKeyClosetToCurrentPosition(state: PagingState<Int, Hero>): HeroRemoteKeys? {
        //anchor position is the most recently accessed index in the list
        return state.anchorPosition?.let { position ->

            //fetch the loaded item that is closest to the last accessed index in the list.
            state.closestItemToPosition(position)?.id?.let { id ->

                //make dao query
                heroRemoteKeysDao.getRemoteKeys(
                        id
                )
                        ?.toModel()
            }
        }
    }


    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, Hero>): HeroRemoteKeys? {

        //get the first pages then check if it is empty
        return state.pages.firstOrNull {
            it.data.isNotEmpty()

            //get the first page and extract hero from it
        }?.data?.firstOrNull()
                ?.let { hero ->
                    heroRemoteKeysDao.getRemoteKeys(hero.id)
                            ?.toModel()
                }
    }


    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, Hero>): HeroRemoteKeys? {


        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
                ?.let {

                    heroRemoteKeysDao.getRemoteKeys(it.id)
                            ?.toModel()
                }
    }



    private fun parseMillis(millis:Long):String{

        val date = Date(millis)

        //used as the language/country neutral locale for the locale sensitive operations
        val sdf = SimpleDateFormat( "yyyy.MM.dd HH.mm", Locale.ROOT)

        return sdf.format(date)
    }
}