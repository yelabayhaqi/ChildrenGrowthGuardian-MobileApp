package com.project.childrenguardian.data.remote.repository

import com.project.childrenguardian.data.local.SessionPreference
import com.project.childrenguardian.data.remote.retrofit.ApiService

class ChildrenRepository private constructor(
    private val apiService: ApiService, private val sessionPreference: SessionPreference
) {
    companion object {
        @Volatile
        private var instance: ChildrenRepository? = null
        fun getInstance(
            apiService: ApiService, loginPreference: SessionPreference
        ): ChildrenRepository = instance ?: synchronized(this) {
            instance ?: ChildrenRepository(apiService, loginPreference)
        }.also { instance = it }
    }
}