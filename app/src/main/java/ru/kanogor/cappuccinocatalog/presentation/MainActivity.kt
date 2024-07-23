package ru.kanogor.cappuccinocatalog.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.kanogor.cappuccinocatalog.presentation.homepage.Homepage
import ru.kanogor.cappuccinocatalog.presentation.homepage.HomepageRoute
import ru.kanogor.cappuccinocatalog.presentation.singlecappuccino.SingleCapp
import ru.kanogor.cappuccinocatalog.presentation.singlecappuccino.SingleCappRoute
import ru.kanogor.cappuccinocatalog.presentation.toolbar.InfoToolbar
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.CappuccinoCatalogTheme
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.ToolbarTextColor
import ru.kanogor.cappuccinocatalog.utils.getCurrentTime
import ru.kanogor.cappuccinocatalog.utils.getRandomTemp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainViewModel by viewModels()

        setContent {
            val time = remember {
                mutableStateOf(getCurrentTime())
            }
            val temp = remember {
                mutableIntStateOf(getRandomTemp())
            }
            viewModel.whatsTimeIsIt()
            temp.intValue = viewModel.temp.collectAsState().value
            time.value = viewModel.time.collectAsState().value
            val navController = rememberNavController()
            CappuccinoCatalogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.Black)
                    ) {
                        InfoToolbar(temp = temp, time = time)
                        HorizontalDivider(
                            color = ToolbarTextColor,
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(1.dp)
                        )
                        Greeting(navController)
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HomepageRoute) {
        composable<HomepageRoute> { _ ->
            Homepage {
                navController.navigate(SingleCappRoute)
            }
        }
        composable<SingleCappRoute> { _ ->
            SingleCapp {
                navController.navigate(HomepageRoute)
            }
        }
    }
}