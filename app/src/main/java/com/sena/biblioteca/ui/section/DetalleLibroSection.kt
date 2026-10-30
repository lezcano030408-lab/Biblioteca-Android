package com.example.biblioteca.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.FileDownload
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.biblioteca.ui.composable.InfoRow
import com.example.biblioteca.ui.model.Libro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleLibroSection(
    libro: Libro,
    onReservarClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle del Libro") },
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
            // Banner de Parámetro Recibido (Exacto a la infografía)
            Surface(
                color = Color(0xFFFFF8E1),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.FileDownload, contentDescription = null, tint = Color(0xFFF57C00))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Parámetro recibido: ${libro.titulo}", color = Color(0xFFE65100), style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Tarjeta miniatura del libro grande centrale
            Card(
                modifier = Modifier.size(120.dp, 160.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF263238))
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(imageVector = Icons.Default.Book, contentDescription = null, tint = Color.White, modifier = Modifier.size(40.dp))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = libro.titulo, color = Color.White, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Datos del libro
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                InfoRow(label = "Nombre:", value = libro.titulo)
                Spacer(modifier = Modifier.height(8.dp))
                InfoRow(label = "Autor:", value = libro.autor)
                Spacer(modifier = Modifier.height(8.dp))
                InfoRow(label = "Categoría:", value = libro.categoria)
                Spacer(modifier = Modifier.height(8.dp))
                InfoRow(label = "Descripción:", value = libro.descripcion)
            }

            Spacer(modifier = Modifier.weight(1f))

            // Botón Naranja de Reservar (Como el diseño)
            Button(
                onClick = onReservarClick,
                enabled = libro.disponible,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF57C00)),
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                Text(text = "Reservar Libro", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}