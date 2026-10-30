package com.example.biblioteca.ui.Screen

import androidx.compose.runtime.Composable
import com.example.biblioteca.ui.model.Libro
import com.example.biblioteca.ui.section.ConfirmacionSection

@Composable
fun ConfirmacionScreen(
    libro: Libro,
    onVolverInicioClick: () -> Unit
) {
    ConfirmacionSection(libro = libro, onVolverInicioClick = onVolverInicioClick)
}