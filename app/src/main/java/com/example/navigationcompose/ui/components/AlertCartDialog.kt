package com.example.navigationcompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AddToCartDialog(
    onDismiss: () -> Unit,
    onConfirm: (Int) -> Unit
) {
    var quantity by remember { mutableStateOf(1) }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            TextButton(onClick = { onConfirm(quantity) }) {
                Text("Añadir")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() } ) {
                Text("Cancelar")
            }
        },
        title = {
            Text("Selecciona la cantidad")
        },
        text = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { if (quantity > 1) quantity-- }
                ) {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Menos")
                }

                Text(
                    text = quantity.toString(),

                )

                IconButton(
                    onClick = { quantity++ }
                ) {
                    Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "Más")
                }
            }
        }
    )
}
