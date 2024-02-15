package com.alberto.srt_marvel.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alberto.srt_marvel.data.remote.model.ComicsData
import com.alberto.srt_marvel.domain.ComicsRepositoryService
import com.alberto.srt_marvel.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val comicsRepositoryService: ComicsRepositoryService
) : ViewModel() {

    private var comicsJob: Job? = null
    private val _comicsState = MutableStateFlow(ComicsState())
    val comicsState = _comicsState.asStateFlow()

    init {
        getComics()
    }

    private fun getComics() {
        comicsJob?.cancel()//This is to cancel any asynchronous calls that come back in the future.
        comicsJob = viewModelScope.launch {
            comicsRepositoryService.getComics()
                .collect { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _comicsState.value = ComicsState(
                                isLoading = true
                            )
                        }

                        is Resource.Success -> {
                            _comicsState.value = ComicsState(
                                data = result.data ?: ComicsData()
                            )
                        }

                        else -> {
                            _comicsState.value = ComicsState(
                                errorMessage = result.message
                                    ?: "Unexpected error loading comics"
                            )
                        }
                    }
                }
            /*
            comicsRepositoryService.getComics().flowOn(Dispatchers.IO) //No need to use this as state flow will sync the coroutines with suspendable functions
            //and there's no need to switch context of dispatchers to run the coroutines in the background thread and then send it to the UI.
            */
        }
    }

}