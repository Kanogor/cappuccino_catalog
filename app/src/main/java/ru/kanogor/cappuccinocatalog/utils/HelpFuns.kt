package ru.kanogor.cappuccinocatalog.utils

import ru.kanogor.cappuccinocatalog.presentation.toolbar.TIME_PATTERN_HOUR_MIN
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

var randomNum = 0

fun getCurrentTime(): String {
    val formatter = DateTimeFormatter.ofPattern(TIME_PATTERN_HOUR_MIN)
    return LocalDateTime.now().format(formatter)
}

fun getRandomTemp(): Int {
    var num = Random.nextInt(85, 95)
    if (num == randomNum) {
        num++
        randomNum = num
    }
    return num
}
