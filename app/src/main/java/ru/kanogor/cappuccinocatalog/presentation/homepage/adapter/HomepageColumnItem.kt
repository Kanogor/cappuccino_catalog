package ru.kanogor.cappuccinocatalog.presentation.homepage.adapter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.kanogor.cappuccinocatalog.R
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.CappCardBotCost
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.CappCardBotRowStart
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.CappCardBotVolume
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.CappCardColorStart
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.TitleTextColor

@Composable
fun HomepageColumnItem(num: Int) {
    val isClicked = remember {
        mutableStateOf(false)
    }
    val notClickedModifier = Modifier
        .size(width = 227.dp, height = 313.dp)
        .padding(12.dp)
    val clickedModifier = Modifier
        .size(width = 233.dp, height = 319.dp)
        .padding(6.dp)
    Card(
        onClick = {
            isClicked.value = !isClicked.value
        },
        modifier = if (isClicked.value) clickedModifier else notClickedModifier,
        shape = RoundedCornerShape(6.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(CappCardColorStart), // добавить градиент
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(top = 28.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                alignment = Alignment.Center,
                painter = painterResource(id = R.drawable.cream_cappuccino),
                contentDescription = "cream_cappuccino",
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = "Капучино эконом $num",
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.montserrat_medium_500)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = TitleTextColor
                ),
                textAlign = TextAlign.Center
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CappCardBotRowStart), // сделать градиент
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "0.33",
                    modifier = Modifier
                        .padding(vertical = 16.dp, horizontal = 9.dp),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.montserrat_medium_500)),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp,
                        color = CappCardBotVolume
                    ),
                )
                Text(
                    text = "199P",
                    modifier = Modifier
                        .padding(vertical = 16.dp, horizontal = 7.dp),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.montserrat_medium_500)),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        color = CappCardBotCost
                    ),
                )
            }
        }
    }
}