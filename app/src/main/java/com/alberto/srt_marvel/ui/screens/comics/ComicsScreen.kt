package com.alberto.srt_marvel.ui.screens.comics

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alberto.srt_marvel.presentation.ComicsViewModel
import com.alberto.srt_marvel.ui.screens.widgets.ErrorScreen
import com.alberto.srt_marvel.ui.screens.widgets.LoadingScreen
import com.alberto.srt_marvel.ui.theme.SRTMarvelTheme

@Composable
fun ComicsScreen(
    viewModel: ComicsViewModel = hiltViewModel(),
    onComicItemClick: (imageUrl: String) -> Unit
) {
    val comicsState = viewModel.comicsState.value

    when {
        comicsState.isLoading -> {
            LoadingScreen(PaddingValues(12.dp))
            viewModel.getComics()
        }

        comicsState.data?.results != null -> {
            val comicResults = comicsState.data.results
            LazyColumn {
                items(comicResults) { comic ->
                    ComicItemScreen(comic = comic, onComicItemClick = onComicItemClick)
                }
            }
        }

        comicsState.errorMessage.isNotEmpty() -> {
            ErrorScreen(
                paddingValues = PaddingValues(12.dp),
                errorMessage = comicsState.errorMessage
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComicsScreenPreview() {
    SRTMarvelTheme {
        ComicsScreen(onComicItemClick = {})
    }
}