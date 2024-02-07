package com.alberto.srt_marvel.ui.screens.comicDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alberto.srt_marvel.R

@Composable
fun ComicDetailScreen(imageUrl: String?) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Comic image detail",
            modifier = Modifier
                .size(500.dp)
        )
    }
}
