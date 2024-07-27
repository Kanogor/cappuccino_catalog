package ru.kanogor.cappuccinocatalog.presentation.singlecappuccino

import android.widget.EditText
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.kanogor.cappuccinocatalog.R
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
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column {
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
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        focusedContainerColor = ToolbarBtnColor,
                        unfocusedContainerColor = ToolbarBtnColor,
                        focusedTextColor = TextFieldTextColor,
                        unfocusedTextColor = TextFieldTextColor,
                        cursorColor = TextFieldTextColor,
                    ),
                )
                Text(
                    text = "Цена",
                    modifier = Modifier.padding(top = 32.dp, bottom = 12.dp),
                    color = TitleTextColor
                )
                OutlinedTextField(value = costText.value, onValueChange = {
                    costText.value = it
                }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        focusedContainerColor = ToolbarBtnColor,
                        unfocusedContainerColor = ToolbarBtnColor,
                        focusedTextColor = TextFieldTextColor,
                        unfocusedTextColor = TextFieldTextColor,
                        cursorColor = TextFieldTextColor,
                        focusedSuffixColor = TextFieldTextColor,
                        unfocusedSuffixColor = TextFieldTextColor,
                    ),
                    suffix = { Text(text = "P") })
                Card(
                    border = BorderStroke(width = 1.dp, color = ToolbarBtnColor),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Black
                    )
                ) {
                    Row {
                        Text(text = "sss")
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