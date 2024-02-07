package com.alberto.srt_marvel.domain

import com.alberto.srt_marvel.data.remote.model.ComicsData
import com.alberto.srt_marvel.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ComicsRepositoryService {
    fun getComics(): Flow<Resource<ComicsData>>
}