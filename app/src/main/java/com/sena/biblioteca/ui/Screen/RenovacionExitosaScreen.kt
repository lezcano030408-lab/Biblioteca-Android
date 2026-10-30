package com.example.biblioteca.ui.Screen

import androidx.compose.runtime.Composable
import com.example.biblioteca.ui.model.Libro
import com.example.biblioteca.ui.section.RenovacionExitosaSection

@Composable
fun RenovacionExitosaScreen(
    libro: Libro, // <-- Asegúrate de que este parámetro esté aquí
    onVolverReservasClick: () -> Unit
) {
    RenovacionExitosaSection(
        libro = libro, // <-- Y pásaselo a su sección correspondiente
        onVolverReservasClick = onVolverReservasClick
    )
}