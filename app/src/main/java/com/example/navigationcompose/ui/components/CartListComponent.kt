package com.example.navigationcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationcompose.data.CartItem

@Composable
fun CartListComponent(cartItem: CartItem,
                      onRemoveFromCart: (Int) -> Unit) {
    Card (
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = CardDefaults.elevatedShape
    ) {

        // Estado local: controla si el diálogo se muestra
        var showDialog by remember { mutableStateOf(false) }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Eliminar producto") },
                text = { Text("¿Seguro que quieres eliminar '${cartItem.title}' del carrito?") },
                confirmButton = {
                    TextButton(
                        onClick = {
                            onRemoveFromCart(cartItem.id)
                            showDialog = false
                        }
                    ) {
                        Text("Eliminar")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(cartItem.image),
                contentDescription = cartItem.title,
                modifier = Modifier.padding(end = 20.dp)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = cartItem.title,
                    fontSize = 16.sp
                )
                Text(
                    text = "Cantidad: ${cartItem.quantity}  Precio: ${cartItem.price}",
                    fontSize = 12.sp
                )
            }
            val subTotal = cartItem.price * cartItem.quantity
            val subTotalText = String.format("%.2f", subTotal)
            Text(
                text = "$subTotalText €",
                fontSize = 16.sp,
                modifier = Modifier.padding(end = 8.dp)
            )

            IconButton(
                onClick = { showDialog = true }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar producto"
                )
            }
        }
    }








}
