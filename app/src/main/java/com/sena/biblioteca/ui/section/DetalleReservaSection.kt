package com.example.biblioteca.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.biblioteca.ui.composable.InfoRow
import com.example.biblioteca.ui.composable.ReservaStatusBadge
import com.example.biblioteca.ui.model.Reserva

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleReservaSection(
    reserva: Reserva,
    onRenovarClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle de Reserva") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Banner de argumentos recibidos
            Surface(
                color = Color(0xFFE8F5E9),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = null, tint = Color(0xFF2E7D32))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Argumentos recibidos: ${reserva.libro.titulo}",
                        color = Color(0xFF1B5E20),
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Miniatura del libro
            Card(
                modifier = Modifier.size(90.dp, 120.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF263238))
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Icon(imageVector = Icons.Default.Book, contentDescription = null, tint = Color.White, modifier = Modifier.size(36.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Datos detallados
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                InfoRow(label = "Nombre:", value = reserva.libro.titulo)
                Spacer(modifier = Modifier.height(6.dp))
                InfoRow(label = "Autor:", value = reserva.libro.autor)
                Spacer(modifier = Modifier.height(6.dp))
                InfoRow(label = "Fecha Reserva:", value = reserva.fechaReserva)
                Spacer(modifier = Modifier.height(6.dp))
                InfoRow(label = "Código Reserva:", value = reserva.idReserva.uppercase())
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Estado:", fontWeight = FontWeight.Bold)
                    ReservaStatusBadge(estado = reserva.estado)
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = onRenovarClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                    modifier = Modifier.weight(1f).height(50.dp)
                ) {
                    Text(text = "Renovar Reserva", color = Color.White, fontWeight = FontWeight.Bold)
                }

                OutlinedButton(
                    onClick = { },
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red),
                    modifier = Modifier.weight(1f).height(50.dp)
                ) {
                    Text(text = "Cancelar Reserva", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}