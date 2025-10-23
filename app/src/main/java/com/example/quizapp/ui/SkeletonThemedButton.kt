package com.example.quizapp.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quizapp.ui.theme.NeonGreenFlash

@Composable
fun SkeletonThemedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val containerColor = if (isPressed) {
        NeonGreenFlash
    } else {
        MaterialTheme.colorScheme.primary
    }

    val contentColor = if (isPressed) {
        Color.Black
    } else {
        MaterialTheme.colorScheme.onPrimary
    }

    Button(
        onClick = onClick,
        modifier = modifier,
        interactionSource = interactionSource, // Pass the interaction tracker
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
        ),
        content = content
    )
}