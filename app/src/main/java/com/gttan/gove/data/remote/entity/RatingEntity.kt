package com.gttan.gove.data.remote.entity

import com.google.gson.annotations.SerializedName

data class RatingEntity(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("rate")
    val rate: Double? = 0.0
)
