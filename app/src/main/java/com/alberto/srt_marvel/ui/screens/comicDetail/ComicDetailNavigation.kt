package com.alberto.srt_marvel.ui.screens.comicDetail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.comicDetailScreen() {
    composable(
        route = ComicDetailDestinations.routeWithArgs,
        arguments = ComicDetailDestinations.arguments
    ) { navBackStackEntry ->
        val imageUrl =
            navBackStackEntry.arguments?.getString(ComicDetailDestinations.comicImageArg)
        ComicDetailScreen(imageUrl)
    }
}