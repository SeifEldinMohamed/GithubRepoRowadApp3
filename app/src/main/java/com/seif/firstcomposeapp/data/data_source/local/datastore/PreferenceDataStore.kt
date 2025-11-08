package com.seif.firstcomposeapp.data.data_source.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.seif.firstcomposeapp.data.Constants.Companion.PREFERENCES_IS_FIRST_TIME_KEY
import com.seif.firstcomposeapp.data.Constants.Companion.PREFERENCES_NAME
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class PreferenceDataStore @Inject constructor(
    private val context: Context
) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = PREFERENCES_NAME
    )

    private val isFirstTimeKey = booleanPreferencesKey(PREFERENCES_IS_FIRST_TIME_KEY)

    suspend fun saveIsFirstFirstTimeEnterApp(isFirstTime: Boolean){
        context.dataStore.edit { mutablePreferences ->
            mutablePreferences[isFirstTimeKey] = isFirstTime
        }
    }

    suspend fun readIsFirstFirstTimeEnterApp(): Boolean {
        return context.dataStore.data.first()[isFirstTimeKey] ?: true
    }
}