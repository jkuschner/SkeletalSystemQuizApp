package com.example.quizapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultsScreen(
    score: Int,
    totalQuestions: Int,
    onRestartClicked: () -> Unit
) {
    // calculate score percentage for display
    val percentage = if (totalQuestions > 0) {
        (score.toFloat() / totalQuestions.toFloat() * 100).toInt()
    } else {
        0
    }

    val message = when {
        percentage == 100 -> "Perfect Score! Amazing work!"
        percentage >= 75 -> "Great Job! You passed with flying colors."
        percentage >= 50 -> "Solid effort! You're getting there."
        else -> "Time to study up! Try again."
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Quiz Results") } )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // result message
            Text(
                text = message,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // score display
            Text(
                text = "Final Score: $score / $totalQuestions",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // percentage display
            Text(
                text = "($percentage%)",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 48.dp)
            )

            // restart button
            Button(
                onClick = onRestartClicked,
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(50.dp)
            ) {
                Text("Try Again", style = MaterialTheme.typography.titleLarge)
            }
        }
    }
}