package ru.kanogor.cappuccinocatalog.presentation.homepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Homepage(onNavigateToSingleCapp: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Homepage")
        Button(modifier = Modifier.fillMaxWidth(), onClick = { onNavigateToSingleCapp() }) {
            Text(text = "To single capp")
        }
    }
}