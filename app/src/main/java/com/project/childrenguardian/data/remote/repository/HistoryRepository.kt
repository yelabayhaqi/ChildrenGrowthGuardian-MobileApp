package com.project.childrenguardian.data.remote.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.project.childrenguardian.data.local.SessionPreference
import com.project.childrenguardian.data.remote.response.HistoryResponse
import com.project.childrenguardian.data.remote.retrofit.ApiService
import com.project.childrenguardian.data.remote.Result

class HistoryRepository private constructor(
    private val apiService: ApiService, private val sessionPreference: SessionPreference
) {
    suspend fun getChildHistory(
        id: Int
    ): LiveData<Result<HistoryResponse>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService.getChildHistory(id)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error("${e.message}"))
        }
    }
    companion object {
        @Volatile
        private var instance: HistoryRepository? = null
        fun getInstance(
            apiService: ApiService, loginPreference: SessionPreference
        ): HistoryRepository = instance ?: synchronized(this) {
            instance ?: HistoryRepository(apiService, loginPreference)
        }.also { instance = it }
    }
}