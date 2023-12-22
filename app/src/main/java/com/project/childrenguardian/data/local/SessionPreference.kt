package com.project.childrenguardian.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.edit
import com.project.childrenguardian.data.models.UserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SessionPreference private constructor(private val dataStore: DataStore<Preferences>) {
    fun getSession(): Flow<UserModel> {
        return dataStore.data.map { preferences ->
            UserModel(
                preferences[EMAIL_KEY] ?: "",
                preferences[TOKEN_KEY] ?: "",
                preferences[IS_LOGIN_KEY] ?: false
            )
        }
    }

    suspend fun saveSessionLogin(userModel: UserModel) {
        dataStore.edit { preferences ->
            preferences[EMAIL_KEY] = userModel.email
            preferences[TOKEN_KEY] = userModel.token
            preferences[IS_LOGIN_KEY] = userModel.isLogin
        }
    }
    suspend fun deleteSessionLogin(): Boolean {
        try {
            dataStore.edit { preferences ->
                preferences[EMAIL_KEY] = ""
                preferences[TOKEN_KEY] = ""
                preferences[IS_LOGIN_KEY] = false
            }
        } catch (e: Exception) {
            return false
        }
        return true
    }
    companion object {
        @Volatile
        private var instance: SessionPreference? = null
        private val IS_LOGIN_KEY = booleanPreferencesKey("isLogin")
        private val TOKEN_KEY = stringPreferencesKey("token")
        private val EMAIL_KEY = stringPreferencesKey("email")
        fun getInstance(dataStore: DataStore<Preferences>): SessionPreference? {
            return instance ?: synchronized(this) {
                val inst = SessionPreference(dataStore)
                instance = inst
                instance
            }
        }
    }
}