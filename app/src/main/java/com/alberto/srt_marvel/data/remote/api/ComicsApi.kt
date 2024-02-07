package com.alberto.srt_marvel.data.remote.api

import com.alberto.srt_marvel.data.common.MARVEL_COMICS_API_CLIENT
import com.alberto.srt_marvel.data.remote.model.Comics
import retrofit2.http.GET

interface ComicsApi {

    @GET(MARVEL_COMICS_API_CLIENT)
    suspend fun getComics(): Comics

}