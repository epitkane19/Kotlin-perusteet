package com.epitkane19.week1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.epitkane19.week1.`ui`.Kotlin_perusteetTheme
import com.epitkane19.week1.view.HomeScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.epitkane19.week1.viewmodel.TaskViewModel
import com.epitkane19.week1.view.CalendarScreen



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: TaskViewModel = viewModel()
            val navController = rememberNavController()

            Kotlin_perusteetTheme {
                NavHost(
                    navController = navController,
                    startDestination = "ROUTE_HOME"
                ) {
                    composable("ROUTE_HOME") {
                        HomeScreen(
                            taskViewModel = viewModel,
                            navigateToCalendar = { navController.navigate("ROUTE_CALENDAR") },
                        )
                    }
                    composable("ROUTE_CALENDAR") {
                        CalendarScreen(
                            taskViewModel = viewModel,
                            navigateToBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kotlin_perusteetTheme {
        Greeting("Android")
    }
}