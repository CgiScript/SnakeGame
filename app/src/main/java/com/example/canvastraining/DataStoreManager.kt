package com.example.canvastraining

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.Preferences


// Create the DataStore instance
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class DataStoreManager(private val context: Context) {
    private val DIFFICULTY_KEY = floatPreferencesKey("difficulty_level")
    private val GRID_SIZE_KEY = floatPreferencesKey("grid_size_level")


    suspend fun saveDifficulty(value: Float) {
        context.dataStore.edit { preferences ->
            preferences[DIFFICULTY_KEY] = value
        }
    }

    val difficultyLevel: Flow<Float> = context.dataStore.data
        .map { preferences ->
            preferences[DIFFICULTY_KEY] ?: 10f
        }


    suspend fun saveSize(value: Float) {
        context.dataStore.edit { preferences ->
            preferences[GRID_SIZE_KEY] = value
        }
    }

    val gridSize: Flow<Float> = context.dataStore.data
        .map { preferences ->
            preferences[GRID_SIZE_KEY] ?: 10f
        }
}