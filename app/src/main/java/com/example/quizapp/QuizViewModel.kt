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
    val currentQuestion: Question
        get() = questions[_currentQuestionIndex.value]
}