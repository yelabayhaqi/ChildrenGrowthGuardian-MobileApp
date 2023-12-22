package com.project.childrenguardian.data.models

data class UserModel(
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)