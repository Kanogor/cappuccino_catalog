package ru.kanogor.cappuccinocatalog.presentation.toolbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.ToolbarTextColor

const val TIME_PATTERN_HOUR_MIN = "HH:mm:ss"

@Composable
fun InfoToolbar(temp: MutableIntState, time: MutableState<String>) {
    val endTextModifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .padding(horizontal = 25.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = { /*TODO*/ }) {

        }
        Row(
            modifier = Modifier.padding(horizontal = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = time.value, modifier = endTextModifier, color = ToolbarTextColor)
            VerticalDivider(
                color = ToolbarTextColor,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Text(text = "${temp.intValue}°", modifier = endTextModifier, color = ToolbarTextColor)
            VerticalDivider(
                color = ToolbarTextColor,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Text(text = "RU", modifier = endTextModifier, color = ToolbarTextColor)
        }
    }
}