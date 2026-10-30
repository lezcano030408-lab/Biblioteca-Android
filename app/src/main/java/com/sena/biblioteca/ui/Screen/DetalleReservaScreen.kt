package com.example.biblioteca.ui.Screen

import androidx.compose.runtime.Composable
import com.example.biblioteca.ui.model.Reserva
import com.example.biblioteca.ui.section.DetalleReservaSection

@Composable
fun DetalleReservaScreen(
    reserva: Reserva,
    onRenovarClick: () -> Unit
) {
    DetalleReservaSection(reserva = reserva, onRenovarClick = onRenovarClick)
}