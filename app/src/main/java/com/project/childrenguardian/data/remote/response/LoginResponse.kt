package com.project.childrenguardian.data.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("meta")
	val meta: Meta? = null,

	@field:SerializedName("response")
	val response: Response? = null
)

data class Meta(

	@field:SerializedName("code")
	val code: Int? = null
)

data class Response(

	@field:SerializedName("csrf_token")
	val csrfToken: String? = null,

	@field:SerializedName("user")
	val user: User? = null
)

data class User(
	val any: Any? = null
)
