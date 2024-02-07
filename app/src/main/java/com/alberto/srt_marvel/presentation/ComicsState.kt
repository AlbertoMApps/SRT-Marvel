package com.alberto.srt_marvel.presentation

import com.alberto.srt_marvel.data.remote.model.ComicsData

data class ComicsState(
    val isLoading: Boolean = false,
    val data: ComicsData? = null,
    val errorMessage: String = ""
)