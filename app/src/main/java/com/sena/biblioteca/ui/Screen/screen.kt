package com.example.biblioteca.ui.Screen

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Inicio : Screen

    @Serializable
    data object ListaLibros : Screen

    @Serializable
    data class DetalleLibro(val libroId: String) : Screen

    @Serializable
    data class Confirmacion(val libroId: String) : Screen

    @Serializable
    data object MisReservas : Screen

    @Serializable
    data class DetalleReserva(val reservaId: String) : Screen

    @Serializable
    data class RenovarReserva(val reservaId: String) : Screen

    @Serializable
    data class RenovacionExitosa(val reservaId: String) : Screen
}