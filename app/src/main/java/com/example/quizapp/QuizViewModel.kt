package com.example.quizapp

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class QuizViewModel : ViewModel() {
    // hardcoded data
    private val _questions = sampleQuestions
    val questions: List<Question> = _questions
    // mutable state
    private val _currentQuestionIndex = mutableStateOf(0)
    private val _score = mutableStateOf(0)
    // exposed state
    val currentQuestionIndex: State<Int> = _currentQuestionIndex
    val score: State<Int> = _score
    // derived state
    val currentQuestion: Question get() = questions[_currentQuestionIndex.value]

    fun submitAnswer(selectedAnswer: String): Boolean {
        // check if answer is correct
        val isCorrect = selectedAnswer == currentQuestion.correctAnswer

        // update score state
        if (isCorrect) {
            _score.value += 1
        }

        // advance to next question
        if (_currentQuestionIndex.value < questions.lastIndex) {
            _currentQuestionIndex.value += 1
        }

        return isCorrect
    }

    fun resetQuiz() {
        _currentQuestionIndex.value = 0
        _score.value = 0
    }
}