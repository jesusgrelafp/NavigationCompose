package com.example.navigationcompose.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationcompose.data.CartItem
import com.example.navigationcompose.ui.components.CartListComponent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(cartItems: List<CartItem>,
               onBack: () -> Unit,
               onRemoveFromCart: (Int) -> Unit
){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text("Carrito de la compra")
                },
                navigationIcon =  {
                    IconButton(onClick = {onBack()}) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )}
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {

            if (cartItems.isEmpty()) {
                Column (Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(Modifier.height(50.dp))
                    Text("Tu carrito está vacío", fontSize = 16.sp)
                }
            } else {
                val total = cartItems.sumOf { it.price * it.quantity }
                val totalText = String.format("%.2f", total)
                Row (Modifier.fillMaxWidth().padding(end =  50.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Total: $totalText €", textAlign = TextAlign.End, fontSize = 24.sp,)
                }
                Spacer(modifier = Modifier.height(30.dp))
                LazyColumn {
                    items(cartItems) { cartItem ->
                        CartListComponent(
                            cartItem = cartItem,
                            onRemoveFromCart = { id -> onRemoveFromCart(id) }
                        )
                    }
                }



            }
        }
    }
}
