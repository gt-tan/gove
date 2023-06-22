package com.gttan.gove.data.local

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.gttan.gove.data.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = Constants.APP_SETTINGS)

class DataStoreManager(context: Context) {

    companion object PreferencesKeys {
        val FIRST_TIME = booleanPreferencesKey(Constants.SETTINGS_FIRST_TIME)
        val SIGNED_IN = booleanPreferencesKey(Constants.SETTINGS_SIGNED_IN)
    }

    private val dataStore = context.dataStore

    suspend fun setFirstTime(firstTime: Boolean) {
        dataStore.edit { preferences ->
            preferences[FIRST_TIME] = firstTime
        }
    }

    val getFirstTime: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[FIRST_TIME] ?: true
    }

    suspend fun setSignedIn(isSignedIn: Boolean) {
        dataStore.edit { preferences ->
            preferences[SIGNED_IN] = isSignedIn
        }
    }

    val getSignedIn: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[SIGNED_IN] ?: false
    }

}
