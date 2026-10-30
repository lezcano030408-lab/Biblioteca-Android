package com.example.biblioteca.ui.model

import kotlinx.serialization.Serializable

@Serializable
data class Reserva(
    val idReserva: String,
    val libro: Libro,
    val fechaReserva: String,
    val fechaDevolucion: String,
    val estado: String // "Activa", "Renovada", "Devuelta"
)