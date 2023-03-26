package com.uxstate.heroes.data.remote_mediator

import androidx.paging.*
import androidx.paging.RemoteMediator.*
import androidx.test.core.app.ApplicationProvider
import com.uxstate.heroes.data.local.HeroDatabase
import com.uxstate.heroes.data.remote.FakeHeroApiTwo
import com.uxstate.heroes.domain.model.Hero
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

/*This class tests that the RemoteMediator is returning the correct
* MediatorResult*/
class HeroRemoteMediatorTest {

    private lateinit var database: HeroDatabase
    private lateinit var api: FakeHeroApiTwo

    @Before
    fun setUp() {
        database = HeroDatabase.create(
                context = ApplicationProvider.getApplicationContext(),
                useInMemory = true
        )
        api = FakeHeroApiTwo()
    }

    //Cleanup function to ensure that the state doesn't leak between test functions
    //After function executes after each test function
    @After
    fun cleanUp() {

        database.clearAllTables()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun refreshLoadReturnsMediatorResultSuccessWhenMoreDataIsPresent() = runBlocking {

        val mediator = HeroRemoteMediator(api = api, database = database)
        val pagingState = PagingState<Int, Hero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
        )

        val result = mediator.load(LoadType.REFRESH, state = pagingState)

        assertTrue(result is MediatorResult.Success)
        assertFalse((result as MediatorResult.Success).endOfPaginationReached)
    }

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun refreshLoadSuccessAndEndOfPaginationTrueWhenNoMoreData() = runBlocking {
        val mediator = HeroRemoteMediator(api, database)
        val state = PagingState<Int, Hero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
        )

        //mess with server data - first page
        api.clearData()

        val result = mediator.load(loadType = LoadType.REFRESH, state = state)

        assertTrue(result is MediatorResult.Success)
        assertTrue((result as MediatorResult.Success).endOfPaginationReached)
    }

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun refreshLoadReturnsMediatorResultErrorWhenErrorOccurs() = runBlocking {

        val mediator = HeroRemoteMediator(api, database)
        val state = PagingState<Int, Hero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
        )

        //mess with api
        api.addException()

        val result = mediator.load(loadType = LoadType.REFRESH,state = state)

        assertTrue(result is RemoteMediator.MediatorResult.Error)

    }
}