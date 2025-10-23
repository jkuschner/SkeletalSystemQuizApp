package com.example.quizapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.quizapp.QuizViewModel
import com.example.quizapp.Question

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    viewModel: QuizViewModel,
    onQuizFinished: (Int) -> Unit
) {
    val currentQuestionIndex by viewModel.currentQuestionIndex
    val score by viewModel.score

    // check if quiz is finished
    val isQuizFinished = currentQuestionIndex >= viewModel.questions.size

    val currentQuestion = if (!isQuizFinished) {
        viewModel.currentQuestion
    } else {
        null
    }
    if (isQuizFinished) {
        onQuizFinished(score)
        return
    }

    // main UI layout
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Compose Quiz") },
                actions = {
                    Text(text = "Score: $score",
                        modifier = Modifier.padding(end = 16.dp))
                    Text(text = "Q: ${currentQuestionIndex + 1}/${viewModel.questions.size}",
                        modifier = Modifier.padding(end = 16.dp))
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // question text
            Text(
                text = currentQuestion?.text ?: "Loading question...",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(vertical = 32.dp)
                    .fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))

            // display answer buttons
            currentQuestion?.answers?.forEach { answer ->
                Button(
                    onClick = { viewModel.submitAnswer(answer) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    contentPadding = PaddingValues(20.dp)
                ) {
                    Text(text = answer)
                }
            }
        }
    }
}