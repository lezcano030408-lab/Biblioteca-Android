package com.example.biblioteca.ui.Screen

import androidx.compose.runtime.Composable
import com.example.biblioteca.ui.model.Reserva
import com.example.biblioteca.ui.section.MisReservasSection

@Composable
fun MisReservasScreen(
    reservas: List<Reserva>,
    onReservaClick: (String) -> Unit
) {
    MisReservasSection(reservas = reservas, onReservaClick = onReservaClick)
}