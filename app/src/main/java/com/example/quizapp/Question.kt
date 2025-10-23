package com.example.quizapp

data class Question(
    val id: Int,
    val text: String,
    val answers: List<String>,
    val correctAnswer: String,
    val imageResId: Int? = null
)