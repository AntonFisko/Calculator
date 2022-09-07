package com.example.calculatortz.ExpressionRepository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class ExpressionRepository(private val context: Context) {

    private val EXPRESSION_PREFERENCES_NAME = "expression_preferences"
    private val EXPRESSION_KEY = stringPreferencesKey("expression")

    private val Context.dataStore by preferencesDataStore(
        name = EXPRESSION_PREFERENCES_NAME
    )

    val expressionFlow: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[EXPRESSION_KEY] ?: ""
        }

    suspend fun setExpression(value: String) {
        context.dataStore.edit { settings ->
            settings[EXPRESSION_KEY] = value
        }
    }
}
