package com.example.quizapp

val sampleQuestions = listOf(
    Question(
        id = 1,
        text = "What is the scientific name for the cheekbone?",
        answers = listOf("Temporal bone", "Maxillae", "Sphenoid", "Zygomatic bone"),
        correctAnswer = "Zygomatic bone",
        imageResId = R.drawable.q1_cheekbone
    ),
    Question(
        id = 2,
        text = "What bone is the only bone in the human body that is NOT connected to any other bone?",
        answers = listOf("Hyoid", "Patella", "Mandible", "Lunate"),
        correctAnswer = "Hyoid",
        imageResId = R.drawable.q2_notouching
    ),
    Question(
        id = 3,
        text = "How many bones are in an adult human body?",
        answers = listOf("97", "360", "206", "186"),
        correctAnswer = "206",
        imageResId = R.drawable.q3_numberofbones
    ),
    Question(
        id = 4,
        text = "Which of these bones is NOT one of the 3 earbones?",
        answers = listOf("Stapes", "Coccyx", "Incus", "Malleus"),
        correctAnswer = "Coccyx",
        imageResId = R.drawable.q4_earbones
    )
)