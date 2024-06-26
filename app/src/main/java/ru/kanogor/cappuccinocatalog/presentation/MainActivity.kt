package ru.kanogor.cappuccinocatalog.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.kanogor.cappuccinocatalog.presentation.homepage.Homepage
import ru.kanogor.cappuccinocatalog.presentation.homepage.HomepageRoute
import ru.kanogor.cappuccinocatalog.presentation.singlecappuccino.SingleCapp
import ru.kanogor.cappuccinocatalog.presentation.singlecappuccino.SingleCappRoute
import ru.kanogor.cappuccinocatalog.presentation.ui.theme.CappuccinoCatalogTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainViewModel by viewModels()

        setContent {
            val navController = rememberNavController()
            CappuccinoCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HomepageRoute) {
        composable<HomepageRoute> { backStackEntry ->
            Homepage {
                navController.navigate(SingleCappRoute)
            }
        }
        composable<SingleCappRoute> { backStackEntry ->
            SingleCapp {
                navController.navigate(HomepageRoute)
            }
        }
    }
}