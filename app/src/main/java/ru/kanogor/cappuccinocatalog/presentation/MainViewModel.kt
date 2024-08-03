package ru.kanogor.cappuccinocatalog.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.kanogor.cappuccinocatalog.utils.getCurrentTime
import ru.kanogor.cappuccinocatalog.utils.getRandomTemp
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _time = MutableStateFlow(getCurrentTime())
    val time = _time.asStateFlow()
    private val _temp = MutableStateFlow(getRandomTemp())
    val temp = _temp.asStateFlow()

    init {
        Log.d("LogTemp", "ViewModel done")
    }

    fun whatsTimeIsIt() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            _time.value = getCurrentTime()
            _temp.value = getRandomTemp()
            Log.d("LogTemp", "time = ${time.value}, temp = ${temp.value}")
        }
    }
}