package com.alberto.srt_marvel

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.alberto.srt_marvel.ui.screens.comicDetail.ComicDetailDestinations
import com.alberto.srt_marvel.ui.screens.comicDetail.comicDetailScreen
import com.alberto.srt_marvel.ui.screens.comics.ComicsDestinations
import com.alberto.srt_marvel.ui.screens.comics.comicsScreen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun MainActivityNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ComicsDestinations.route
    ) {
        comicsScreen(onComicItemClick = { imageUrl ->
            val encodedimageUrl = URLEncoder.encode(imageUrl, StandardCharsets.UTF_8.toString())
            navController.navigate("${ComicDetailDestinations.route}/$encodedimageUrl")
        })
        comicDetailScreen()
    }
}