package ru.kanogor.cappuccinocatalog.presentation.homepage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.kanogor.cappuccinocatalog.presentation.homepage.adapter.HomepageColumnItem

@Composable
fun Homepage(onNavigateToSingleCapp: () -> Unit) {
    val capps = (1..15).toList()
    Column(modifier = Modifier.fillMaxSize()) {
        Button(modifier = Modifier
            .fillMaxWidth(), onClick = { onNavigateToSingleCapp() }) {
            Text(text = "To single capp")
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 230.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            itemsIndexed(items = capps) { item, index ->
                HomepageColumnItem(item)
            }
        }
    }
}