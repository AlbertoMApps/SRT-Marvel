package com.alberto.srt_marvel.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.alberto.srt_marvel.presentation.ComicsViewModel
import com.alberto.srt_marvel.ui.theme.SRTMarvelTheme

@Composable
fun ComicsScreen(
    viewModel: ComicsViewModel = hiltViewModel()
) {
    val comicsState = viewModel.comicsState.collectAsState().value

    when {
        comicsState.data?.results != null -> {
            viewModel.getComics()
            val comicResults = comicsState.data.results
            LazyColumn {
                items(comicResults) { comic ->
                    ComicItemScreen(comic = comic)
                }
            }
        }

        comicsState.errorMessage.isNotEmpty() -> {
            //TODO Error handling here...
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SRTMarvelTheme {
        ComicsScreen()
    }
}