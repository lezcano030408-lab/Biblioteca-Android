package com.example.biblioteca.ui.model

import kotlinx.serialization.Serializable

@Serializable
data class Libro(
    val id: String,
    val titulo: String,
    val autor: String,
    val categoria: String,
    val descripcion: String,
    val disponible: Boolean,
    val imagenUrl: String = ""
)