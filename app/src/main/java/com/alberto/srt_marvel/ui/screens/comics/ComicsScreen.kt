package com.alberto.srt_marvel.ui.screens.comics

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
    val comicsState = viewModel.comicsState.collectAsState().value
//    LaunchedEffect(key1 = null, block = {
//        viewModel.getComics()
//    })// Not used before, but this will be good for when the composable is first launched/relaunched, when we want to request some data
    // from the VM in a suspend function or run some sort of animation.
    // We can also avoid this, since we're using coroutines in a mutable state of comics and we'll relaunch the latest coroutines when it's updated.

    when {
        comicsState.isLoading -> {
            LoadingScreen(PaddingValues(12.dp))
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
        ComicsScreen(
            viewModel = hiltViewModel(),
            onComicItemClick = {})
    }
}