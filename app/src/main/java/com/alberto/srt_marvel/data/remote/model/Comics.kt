package com.alberto.srt_marvel.data.remote.model

import com.google.gson.annotations.SerializedName

data class Comics(
    @SerializedName("data")
    val data: ComicsData? = null
)