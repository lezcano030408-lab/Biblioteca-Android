package com.example.biblioteca.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.biblioteca.ui.Screen.*
import com.example.biblioteca.ui.model.Libro
import com.example.biblioteca.ui.model.Reserva
import com.example.biblioteca.ui.section.RenovarReservaSection
import java.time.LocalDate

val librosFicticios = listOf(
    Libro("1", "Cien Años de Soledad", "Gabriel García Márquez", "Novela", "Obra maestra del realismo mágico.", true),
    Libro("2", "El Principito", "Antoine de Saint-Exupéry", "Fábula", "Un clásico de la literatura universal.", true),
    Libro("3", "Don Quijote de la Mancha", "Miguel de Cervantes", "Clásico", "La gran obra de la literatura española.", true),
    Libro("4", "Dragon ball y sus sagas", "Akira Toriyama", "Anime", "La gran batalla de los sayajines", true)
)

@Composable
fun AppNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    val listaReservas = remember { mutableStateListOf<Reserva>() }

    NavHost(
        navController = navController,
        startDestination = Screen.Inicio,
        modifier = modifier
    ) {
        composable<Screen.Inicio> {
            InicioScreen(
                onVerCatalogoClick = { navController.navigate(Screen.ListaLibros) },
                onVerReservasClick = { navController.navigate(Screen.MisReservas) }
            )
        }

        composable<Screen.ListaLibros> {
            ListaLibrosScreen(
                libros = librosFicticios,
                onLibroClick = { libroId -> navController.navigate(Screen.DetalleLibro(libroId)) }
            )
        }

        composable<Screen.DetalleLibro> { backStackEntry ->
            val route: Screen.DetalleLibro = backStackEntry.toRoute()
            val libro = librosFicticios.find { it.id == route.libroId } ?: librosFicticios[0]

            DetalleLibroScreen(
                libro = libro,
                onReservarClick = {
                    val nuevaReserva = Reserva(
                        idReserva = "r_${System.currentTimeMillis()}",
                        libro = libro,
                        fechaReserva = LocalDate.now().toString(),
                        fechaDevolucion = LocalDate.now().plusDays(15).toString(),
                        estado = "Activa"
                    )
                    if (listaReservas.none { it.libro.id == libro.id }) {
                        listaReservas.add(nuevaReserva)
                    }

                    navController.navigate(Screen.Confirmacion(libro.id))
                }
            )
        }

        composable<Screen.Confirmacion> { backStackEntry ->
            val route: Screen.Confirmacion = backStackEntry.toRoute()
            val libro = librosFicticios.find { it.id == route.libroId } ?: librosFicticios[0]

            ConfirmacionScreen(
                libro = libro,
                onVolverInicioClick = {
                    navController.navigate(Screen.Inicio) {
                        popUpTo(Screen.Inicio) { inclusive = true }
                    }
                }
            )
        }

        composable<Screen.MisReservas> {
            MisReservasScreen(
                reservas = listaReservas,
                onReservaClick = { reservaId -> navController.navigate(Screen.DetalleReserva(reservaId)) }
            )
        }

        composable<Screen.DetalleReserva> { backStackEntry ->
            val route: Screen.DetalleReserva = backStackEntry.toRoute()
            val reserva = listaReservas.find { it.idReserva == route.reservaId }

            if (reserva != null) {
                DetalleReservaScreen(
                    reserva = reserva,
                    onRenovarClick = { navController.navigate(Screen.RenovarReserva(reserva.idReserva)) }
                )
            }
        }

        composable<Screen.RenovarReserva> { backStackEntry ->
            val route: Screen.RenovarReserva = backStackEntry.toRoute()
            val reservaIndex = listaReservas.indexOfFirst { it.idReserva == route.reservaId }

            if (reservaIndex != -1) {
                val reserva = listaReservas[reservaIndex]
                RenovarReservaSection(
                    reserva = reserva,
                    onConfirmarRenovacionClick = {
                        listaReservas[reservaIndex] = reserva.copy(estado = "Renovada")
                        // Aquí le pasamos el idReserva que exige la ruta Screen.RenovacionExitosa
                        navController.navigate(Screen.RenovacionExitosa(reserva.idReserva))
                    },
                    onBackClick = { navController.popBackStack() }
                )
            }
        }

        composable<Screen.RenovacionExitosa> { backStackEntry ->
            val route: Screen.RenovacionExitosa = backStackEntry.toRoute()
            // Buscamos la reserva en nuestra lista dinámica usando el reservaId de la ruta
            val reserva = listaReservas.find { it.idReserva == route.reservaId }
            val libro = reserva?.libro ?: librosFicticios[0]

            RenovacionExitosaScreen(
                libro = libro,
                onVolverReservasClick = {
                    navController.navigate(Screen.MisReservas) {
                        popUpTo(Screen.MisReservas) { inclusive = true }
                    }
                }
            )
        }
    }
}