package com.alberto.srt_marvel.ui.screens.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alberto.srt_marvel.ui.theme.SRTMarvelTheme

@Composable
fun ErrorScreen(paddingValues: PaddingValues, errorMessage: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Text(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            textAlign = TextAlign.Center,
            text = errorMessage
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    SRTMarvelTheme {
        ErrorScreen(paddingValues = PaddingValues(12.dp), errorMessage = "Error message")
    }
}