package com.alberto.srt_marvel.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.alberto.srt_marvel.data.remote.model.ComicResult

@Composable
fun ComicItemScreen(comic: ComicResult) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
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
                comic.thumbnail?.takeIf { !it.path.isNullOrEmpty() && !it.extension.isNullOrEmpty() }
                    .let {
                        Image(
                            painter = rememberAsyncImagePainter(model = comic.thumbnail?.path + comic.thumbnail?.extension),
                            contentDescription = comic.title,
                            modifier = Modifier
                                .size(128.dp)
                                .weight(4f)
                        )
                    }
                comic.title?.let {
                    Text(
                        text = it,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.weight(4f)
                    )
                }
            }
        }
    }
}