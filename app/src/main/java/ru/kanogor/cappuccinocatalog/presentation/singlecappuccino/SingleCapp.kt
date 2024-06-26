package ru.kanogor.cappuccinocatalog.presentation.singlecappuccino

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SingleCapp(onNavigateToSingleCapp: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "SingleCapp")
        Button(modifier = Modifier.fillMaxWidth(), onClick = { onNavigateToSingleCapp() }) {
            Text(text = "To Homepage")
        }
    }
}