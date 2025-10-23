package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import com.example.quizapp.ui.theme.QuizAppTheme
import com.example.quizapp.navigation.Screen
import com.example.quizapp.QuizViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun QuizAppNavigation() {
    val navController = rememberNavController()
    val viewModel: QuizViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        // Home screen composable
        composable(Screen.Home.route) {
            // TODO: implement logic
            HomeScreen(
                onStartQuizClicked = {
                    viewModel.resetQuiz()
                    navController.navigate(Screen.Quiz.route)
                }
            )
        }

        // quiz screen composable
        composable(Screen.Quiz.route) {
            // TODO: implement logic
            QuizScreen(
                viewModel = viewModel,
                onQuizFinished = { finalScore ->
                    navController.navigate(Screen.Results.createRoute(finalScore)) {
                        // clear quiz screen from back stack so back button goes to home after results
                        popUpTo(Screen.Home.route) { inclusive = false}
                    }
                }
            )
        }

        // results screen composable
        composable(
            route = Screen.Results.route,
            arguments = listOf(
                navArgument("score") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) { backStackEntry ->
           val score = backStackEntry.arguments?.getInt("score") ?: 0

            // TODO: implement logic
            ResultsScreen(
                score = score,
                totalQuestions = viewModel.questions.size,
                onRestartClicked = {
                    navController.popBackStack(Screen.Home.route, inclusive = false)
                }
            )
        }
    }
}
