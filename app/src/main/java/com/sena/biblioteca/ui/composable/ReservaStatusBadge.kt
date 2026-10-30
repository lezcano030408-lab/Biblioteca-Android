package com.example.biblioteca.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ReservaStatusBadge(estado: String) {
    val backgroundColor = when (estado) {
        "Activa" -> Color(0xFF4CAF50)
        "Renovada" -> Color(0xFF2196F3)
        else -> Color.Gray
    }

    Box(
        modifier = Modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = estado,
            color = Color.White,
            fontSize = 12.sp
        )
    }
}