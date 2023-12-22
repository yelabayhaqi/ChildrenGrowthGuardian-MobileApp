package com.project.childrenguardian.data.remote.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.google.gson.Gson
import com.project.childrenguardian.data.local.SessionPreference
import com.project.childrenguardian.data.models.UserModel
import com.project.childrenguardian.data.remote.response.LoginResponse
import com.project.childrenguardian.data.remote.retrofit.ApiService
import com.project.childrenguardian.data.remote.Result
import com.project.childrenguardian.data.remote.response.ErrorResponse
import retrofit2.HttpException


class UserRepository private constructor (
    private val apiService: ApiService,
    private val sessionPreference: SessionPreference
) {
    fun login(
        email: String,
        password: String
    ): LiveData<Result<LoginResponse>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService.login(email, password)
            val name = response.response?.user.toString()
            val token = response.response?.csrfToken.toString()
            sessionPreference.saveSessionLogin(
                UserModel(
                    email = name,
                    token = token,
                    isLogin = true
                )
            )
            emit(Result.Success(response))
        } catch (e: Exception) {
            val errorMessage = when {
                e is HttpException && (e.code() == 400 || e.code() == 401) -> {
                    val errorResponse = Gson().fromJson(e.response()?.errorBody()?.string(), ErrorResponse::class.java)
                    errorResponse?.message ?: "Unknown error"
                }
                else -> e.message ?: "Unknown error"
            }
            emit(Result.Error("Error : $errorMessage"))
        }
    }
    suspend fun register(
        name: String,
        email: String,
        password: String
    ): LiveData<Result<ErrorResponse>> =
        liveData {
            emit(Result.Loading)
            try {
                val response = apiService.register(name, email, password)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    responseBody?.let { emit(Result.Success(it)) } ?: emit(Result.Error("Invalid response"))
                } else {
                    val errorResponse = Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                    val errorMessage = errorResponse?.message ?: "Unknown error"
                    emit(Result.Error("Error : $errorMessage"))
                }
            } catch (e: Exception) {
                val errorMessage = when {
                    e is HttpException && (e.code() == 400 || e.code() == 401) -> {
                        val errorResponse = Gson().fromJson(e.response()?.errorBody()?.string(), ErrorResponse::class.java)
                        errorResponse?.message ?: "Unknown error"
                    }
                    else -> e.message ?: "Unknown error"
                }
                emit(Result.Error("Error : $errorMessage"))
            }
        }

    fun getPref() = sessionPreference

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            apiService: ApiService,
            loginPreference: SessionPreference
        ): UserRepository = instance ?: synchronized(this) {
            instance ?: UserRepository(apiService, loginPreference)
        }.also { instance = it }
    }
}