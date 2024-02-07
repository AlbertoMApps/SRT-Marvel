package com.alberto.srt_marvel.data.repository

import com.alberto.srt_marvel.data.remote.api.ComicsApi
import com.alberto.srt_marvel.data.remote.model.ComicsData
import com.alberto.srt_marvel.domain.ComicsRepositoryService
import com.alberto.srt_marvel.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ComicsRepositoryImplementation @Inject constructor(
    private val comicsApi: ComicsApi
) : ComicsRepositoryService {

    override fun getComics(): Flow<Resource<ComicsData>> = flow {
        emit(Resource.Loading())
        val comics = comicsApi.getComics()
        emit(Resource.Success(data = comics.data))
    }.catch {
        emit(
            Resource.Error(
                message = it.localizedMessage ?: "Unexpected error loading random comics data"
            )
        )
    }

}