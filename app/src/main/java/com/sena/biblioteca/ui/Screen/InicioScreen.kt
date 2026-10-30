package com.example.biblioteca.ui.Screen

import androidx.compose.runtime.Composable
import com.example.biblioteca.ui.section.InicioSection

@Composable
fun InicioScreen(
    onVerCatalogoClick: () -> Unit,
    onVerReservasClick: () -> Unit
) {
    InicioSection(
        onVerCatalogoClick = onVerCatalogoClick,
        onVerReservasClick = onVerReservasClick
    )
}