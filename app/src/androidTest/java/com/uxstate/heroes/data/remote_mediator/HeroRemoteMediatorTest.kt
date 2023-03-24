package com.uxstate.heroes.data.remote_mediator

import androidx.test.core.app.ApplicationProvider
import com.uxstate.heroes.data.local.HeroDatabase
import com.uxstate.heroes.data.remote.FakeHeroApiTwo
import org.junit.After
import org.junit.Before

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

    //Cleanup function to ensure that the state doesn't leak between test function
    //After function executes after each test function
    @After
    fun cleanUp() {

        database.clearAllTables()
    }

}