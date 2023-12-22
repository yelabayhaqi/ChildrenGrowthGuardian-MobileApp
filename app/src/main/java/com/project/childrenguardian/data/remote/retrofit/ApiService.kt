package com.project.childrenguardian.data.remote.retrofit

import com.project.childrenguardian.data.remote.response.ErrorResponse
import com.project.childrenguardian.data.remote.response.HistoryResponse
import com.project.childrenguardian.data.remote.response.LoginResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @POST("register")
    @FormUrlEncoded
    suspend fun register(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<ErrorResponse>

    @POST("login")
    @FormUrlEncoded
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @POST("getChildHistory")
    @FormUrlEncoded
    suspend fun getChildHistory(
        @Field("child_id") childId: Int
    ): HistoryResponse

}