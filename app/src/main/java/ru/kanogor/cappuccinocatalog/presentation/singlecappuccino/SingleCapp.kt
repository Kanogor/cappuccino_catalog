package ru.kanogor.cappuccinocatalog.presentation.singlecappuccino

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.kanogor.cappuccinocatalog.R
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.SwitchGradientEnd
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.SwitchGradientStart
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.TextFieldColor
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.TextFieldTextColor
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.TitleTextColor
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.ToolbarBtnColor

@Composable
fun SingleCapp(onNavigateToSingleCapp: () -> Unit) {
    val nameText = remember {
        mutableStateOf("")
    }
    val costText = remember {
        mutableStateOf("")
    }
    val switchChecked = remember {
        mutableStateOf(false)
    }
    val switchGradient = Brush.radialGradient(listOf(SwitchGradientStart, SwitchGradientEnd))
    val fieldTextColor = OutlinedTextFieldDefaults.colors(
        unfocusedBorderColor = Color.Transparent,
        focusedBorderColor = Color.Transparent,
        focusedContainerColor = TextFieldColor,
        unfocusedContainerColor = TextFieldColor,
        focusedTextColor = TextFieldTextColor,
        unfocusedTextColor = TextFieldTextColor,
        cursorColor = TextFieldTextColor,
        focusedSuffixColor = TextFieldTextColor,
        unfocusedSuffixColor = TextFieldTextColor,
        disabledContainerColor = ToolbarBtnColor
    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .padding(vertical = 24.dp)
                    .verticalScroll(rememberScrollState())
                    .weight(1f, false)
            ) {
                Text(
                    text = "Наименование",
                    modifier = Modifier.padding(bottom = 12.dp),
                    color = TitleTextColor
                )
                OutlinedTextField(
                    value = nameText.value,
                    onValueChange = {
                        nameText.value = it
                    },
                    modifier = Modifier.width(418.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = fieldTextColor,
                )
                Text(
                    text = "Цена",
                    modifier = Modifier.padding(top = 32.dp, bottom = 12.dp),
                    color = TitleTextColor
                )
                OutlinedTextField(value = costText.value, onValueChange = {
                    costText.value = it
                },
                    modifier = Modifier.width(418.dp),
                    enabled = !switchChecked.value,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    shape = RoundedCornerShape(12.dp),
                    colors = fieldTextColor,
                    suffix = { Text(text = "₽") })
                Card(
                    border = BorderStroke(width = 1.dp, color = ToolbarBtnColor),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(418.dp)
                        .padding(top = 12.dp, bottom = 64.dp)
                ) {
                    Row( modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Продавать бесплатно",
                            modifier = Modifier
                                .padding(start = 24.dp, end = 81.dp, top = 13.dp, bottom = 13.dp),

                            )
                        Switch(
                            checked = switchChecked.value, onCheckedChange = { checked ->
                                switchChecked.value = checked
                            }, modifier = Modifier.padding(end = 24.dp),
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = SwitchGradientStart,
                                uncheckedThumbColor = Color.White,
                                uncheckedTrackColor = SwitchGradientEnd,
                                uncheckedBorderColor = SwitchGradientEnd,
                            )
                        )
                    }
                }
                Button(onClick = { onNavigateToSingleCapp() }) {
                    Text(text = "Сохранить", style = MaterialTheme.typography.titleLarge)
                }
            }
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                modifier = Modifier.size(154.dp),
                contentDescription = ""
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                modifier = Modifier.size(154.dp),
                contentDescription = ""
            )
        }
    }
}