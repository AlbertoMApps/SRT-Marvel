package com.alberto.srt_marvel.data.repository

import com.alberto.srt_marvel.data.remote.api.ComicsApi
import com.alberto.srt_marvel.data.remote.model.ComicResult
import com.alberto.srt_marvel.data.remote.model.Comics
import com.alberto.srt_marvel.data.remote.model.ComicsData
import com.alberto.srt_marvel.data.remote.model.Thumbnail
import com.alberto.srt_marvel.domain.ComicsRepositoryService
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class ComicsRepositoryImplementationTest {

    @Mock
    private lateinit var comicsApi: ComicsApi
    private lateinit var comicsRepository: ComicsRepositoryService

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        comicsRepository =
            ComicsRepositoryImplementation(comicsApi)
    }

    @Test
    fun `When getComics is called, then we receive a list of comics with details`() =
        runTest {
            whenever(comicsApi.getComics())
                .thenReturn(
                    Comics(
                        data = ComicsData(
                            results = listOf(
                                ComicResult(
                                    title = "Marvel",
                                    thumbnail = Thumbnail(path = "imageUrl", extension = "jpg")
                                )
                            )
                        )
                    )
                )

            val result = comicsRepository.getComics().toList()
            comicsApi.getComics().data?.results?.apply {
                assertEquals(this[0].title, result[1].data!!.results!![0].title)
                assertEquals(this[0].thumbnail, result[1].data!!.results!![0].thumbnail)
            }
        }
    // We could make the error cases here too...
}
