package com.uxstate.heroes.data.prefs

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.uxstate.heroes.domain.repository.DataStoreOperations
import com.uxstate.heroes.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


//extension variable from DataStore
val Context.dataStore by preferencesDataStore(
        name =
        Constants.PREFERENCES_NAME
)

//pass context to the impl class
class DataStoreOperationsImpl(context: Context) : DataStoreOperations {

    //create a private key object
    private object PrefKeysObject {

        val onboardingKey =
            booleanPreferencesKey(Constants.COMPLETED_ONBOARDING_PREF_KEY)
    }

    //create an instance of the DataStore
    private val dataStore = context.dataStore


    override suspend fun saveOnBoardingState(isCompleted: Boolean) {
        dataStore.edit { prefs -> prefs[PrefKeysObject.onboardingKey] = isCompleted }
    }


    override fun readOnBoardingState(): Flow<Boolean> {
        //to read data by accessing the data property from database instance
        return dataStore.data.map { prefs -> prefs[onboardingke] }

    }
}