package com.alberto.srt_marvel.ui.screens.comics

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.comicsScreen(
    onComicItemClick: (imageUrl: String) -> Unit
) {
    composable(
        route = ComicsDestinations.route
    ) {
        ComicsScreen(
            onComicItemClick = onComicItemClick
        )
    }
}