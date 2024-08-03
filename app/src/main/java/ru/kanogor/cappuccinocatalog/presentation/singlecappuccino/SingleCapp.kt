package ru.kanogor.cappuccinocatalog.presentation.singlecappuccino

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.kanogor.cappuccinocatalog.R
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.SaveBtnContainer
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.SaveBtnText
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.SwitchGradientEnd
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.SwitchGradientStart
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.TextFieldColor
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.TextFieldTextColor
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.TitleTextColor
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.ToolbarBtnColor

@Composable
fun SingleCapp(onNavigateToSingleCapp: () -> Unit) { // поработать над шрифтом и логикой
    val nameText = remember {
        mutableStateOf("")
    }
    val costText = remember {
        mutableStateOf("")
    }
    val switchChecked = remember {
        mutableStateOf(false)
    }
    val cappImageModifier = Modifier
        .fillMaxHeight(0.7f)
        .padding(top = 40.dp, start = 25.dp, end = 25.dp)
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
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(0.65f)
                .padding(end = 60.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.End
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 8.dp, end = 60.dp),
                verticalArrangement = Arrangement.Center
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
                    Row(
                        modifier = Modifier.fillMaxWidth(),
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
                Button(
                    modifier = Modifier,
                    onClick = { onNavigateToSingleCapp() },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = SaveBtnContainer,
                        contentColor = SaveBtnText
                    )
                ) {
                    Text(
                        text = "Сохранить",
                        modifier = Modifier.padding(horizontal = 24.dp),
                        fontFamily = FontFamily(Font(R.font.montserrat_medium_500)),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                }
            }
            CappImage(
                modifier = cappImageModifier,
                painter = painterResource(id = R.drawable.cream_cappuccino)
            )
            CappImage(
                modifier = cappImageModifier,
                painter = painterResource(id = R.drawable.mokkachino)
            )
        }
    }
}

@Composable
fun CappImage(modifier: Modifier, painter: Painter) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 20.dp)
                .align(alignment = Alignment.TopCenter),
            painter = painter,
            contentDescription = "cream_cappuccino",
            contentScale = ContentScale.FillHeight
        )
        Image(
            painter = painterResource(id = R.drawable.ic_check),
            modifier = Modifier
                .size(32.dp)
                .padding(bottom = 7.dp)
                .align(alignment = Alignment.BottomCenter),
            contentDescription = "cream_cappuccino"
        )
    }
}