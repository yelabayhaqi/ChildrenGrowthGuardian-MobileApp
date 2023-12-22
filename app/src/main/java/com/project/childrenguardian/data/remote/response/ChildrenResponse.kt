package com.project.childrenguardian.data.remote.response

import com.google.gson.annotations.SerializedName

data class ChildrenResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null
)

data class DataItem(

	@field:SerializedName("firstname")
	val firstname: String? = null,

	@field:SerializedName("lastCheck")
	val lastCheck: String? = null,

	@field:SerializedName("child_id")
	val childId: Int? = null,

	@field:SerializedName("gender")
	val gender: Int? = null,

	@field:SerializedName("dob")
	val dob: String? = null,

	@field:SerializedName("lastname")
	val lastname: String? = null
)
