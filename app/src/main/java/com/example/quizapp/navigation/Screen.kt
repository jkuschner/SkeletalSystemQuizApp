package com.example.quizapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Quiz : Screen("quiz_screen")
    object Results : Screen("results_screen/{score}") {
        fun createRoute(score: Int) = "results_screen/$score"
    }
}