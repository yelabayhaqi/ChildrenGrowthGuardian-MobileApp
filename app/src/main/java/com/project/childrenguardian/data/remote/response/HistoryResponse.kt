package com.project.childrenguardian.data.remote.response

import com.google.gson.annotations.SerializedName

data class HistoryResponse(

	@field:SerializedName("data")
	val data: List<HistoryItem?>? = null
)

data class HistoryItem(

	@field:SerializedName("checkedAt")
	val checkedAt: String? = null,

	@field:SerializedName("weight")
	val weight: Any? = null,

	@field:SerializedName("checkResult")
	val checkResult: String? = null,

	@field:SerializedName("age")
	val age: Int? = null,

	@field:SerializedName("bmi")
	val bmi: Any? = null,

	@field:SerializedName("height")
	val height: Any? = null
)
