package ru.kanogor.cappuccinocatalog.presentation.toolbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.kanogor.cappuccinocatalog.R
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.ToolbarBtnColor

const val TIME_PATTERN_HOUR_MIN = "HH:mm"

@Composable
fun InfoToolbar(temp: MutableIntState, time: MutableState<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .padding(horizontal = 25.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextButton(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.ic_toolbar_union),
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(24.dp),
                contentDescription = stringResource(R.string.icon)
            )
            Text(
                text = stringResource(R.string.toolbar_btn),
                style = MaterialTheme.typography.titleLarge
            )
        }
        Row(
            modifier = Modifier.padding(horizontal = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = time.value,
                style = MaterialTheme.typography.titleLarge,
            )
            VerticalDivider(
                color = ToolbarBtnColor,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 24.dp)
                    .width(1.dp)
            )
            Row(
                modifier = Modifier.width(83.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.temp, temp.intValue),
                    style = MaterialTheme.typography.titleLarge,
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_temp),
                    modifier = Modifier
                        .size(11.dp),
                    contentDescription = "ic temp"
                )
            }
            VerticalDivider(
                color = ToolbarBtnColor,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ru_flag),
                modifier = Modifier
                    .padding(start = 24.dp, end = 5.dp)
                    .size(11.dp),
                contentDescription = stringResource(R.string.flag)
            )
            Text(
                text = stringResource(R.string.rus),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}