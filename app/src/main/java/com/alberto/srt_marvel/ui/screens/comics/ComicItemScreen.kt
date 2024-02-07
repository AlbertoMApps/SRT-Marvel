package com.alberto.srt_marvel.ui.screens.comics

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alberto.srt_marvel.R
import com.alberto.srt_marvel.data.remote.model.ComicResult
import com.alberto.srt_marvel.ui.theme.SRTMarvelTheme

@Composable
fun ComicItemScreen(
    comic: ComicResult,
    onComicItemClick: (imageUrl: String) -> Unit
) {
    val comicImage = comic.thumbnail?.path + "." + comic.thumbnail?.extension

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onComicItemClick(comicImage) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = comicImage,
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = comic.title,
                    modifier = Modifier
                        .size(128.dp)
                        .weight(3f)
                )
                comic.title?.let {
                    Text(
                        text = it,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.weight(7f)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComicItemScreenPreview() {
    SRTMarvelTheme {
        ComicItemScreen(
            ComicResult(
                title = "Marvel"
            ),
            onComicItemClick = {}
        )
    }
}