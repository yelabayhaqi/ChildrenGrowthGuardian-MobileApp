package com.project.childrenguardian.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.project.childrenguardian.data.local.SessionPreference
import com.project.childrenguardian.data.remote.repository.ChildrenRepository
import com.project.childrenguardian.data.remote.repository.UserRepository
import com.project.childrenguardian.data.remote.retrofit.ApiConfig

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_login")

object Injection {
    fun userProviderRepository(context: Context): UserRepository {
        val apiService = ApiConfig.getApiService()
        val userPreferences = SessionPreference.getInstance(context.dataStore)

        return UserRepository.getInstance(apiService, userPreferences!!)
    }

    fun childrenProviderRepository(context: Context): ChildrenRepository {
        val apiService = ApiConfig.getApiService()
        val userPreferences = SessionPreference.getInstance(context.dataStore)

        return ChildrenRepository.getInstance(apiService, userPreferences!!)
    }
}