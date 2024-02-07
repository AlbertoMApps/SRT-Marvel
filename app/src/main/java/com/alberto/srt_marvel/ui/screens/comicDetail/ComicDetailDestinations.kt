package com.alberto.srt_marvel.ui.screens.comicDetail

import androidx.navigation.NavType
import androidx.navigation.navArgument

object ComicDetailDestinations {
    const val route = "comic_detail"
    const val comicImageArg = "comic_image_arg"
    val routeWithArgs = "${route}/{${comicImageArg}}"
    val arguments = listOf(
        navArgument(comicImageArg) { type = NavType.StringType }
    )
}