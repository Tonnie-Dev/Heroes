package com.uxstate.heroes.data.prefs

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.uxstate.heroes.domain.repository.DataStoreOperations
import com.uxstate.heroes.util.Constants
import kotlinx.coroutines.flow.Flow






//extension variable from DataStore
val Context.dataStore by preferencesDataStore(name =
Constants.PREFERENCES_NAME)


private val COUNTER_KEY = intPreferencesKey("counter_key")



class DataStoreOperationsImpl : DataStoreOperations {
    override suspend fun saveOnBoardingState(isCompleted: Boolean) {
        TODO("Not yet implemented")
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        TODO("Not yet implemented")
    }
}