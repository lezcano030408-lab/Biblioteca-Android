package com.example.biblioteca.ui.Screen

import androidx.compose.runtime.Composable
import com.example.biblioteca.ui.model.Reserva
import com.example.biblioteca.ui.section.RenovarReservaSection

@Composable
fun RenovarReservaScreen(
    reserva: Reserva,
    onConfirmarRenovacionClick: () -> Unit
) {
    RenovarReservaSection(reserva = reserva, onConfirmarRenovacionClick = onConfirmarRenovacionClick)
}