package com.example.biblioteca.ui.Screen

import androidx.compose.runtime.Composable
import com.example.biblioteca.ui.model.Libro
import com.example.biblioteca.ui.section.ListaLibrosSection

@Composable
fun ListaLibrosScreen(
    libros: List<Libro>,
    onLibroClick: (String) -> Unit
) {
    ListaLibrosSection(libros = libros, onLibroClick = onLibroClick)
}