package com.example.biblioteca.ui.Screen

import androidx.compose.runtime.Composable
import com.example.biblioteca.ui.model.Libro
import com.example.biblioteca.ui.section.DetalleLibroSection

@Composable
fun DetalleLibroScreen(
    libro: Libro,
    onReservarClick: () -> Unit
) {
    DetalleLibroSection(libro = libro, onReservarClick = onReservarClick)
}