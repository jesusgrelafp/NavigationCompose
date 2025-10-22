package com.example.navigationcompose.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationcompose.data.Product
import com.example.navigationcompose.ui.components.ProductListComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(products: List<Product>,
               total: Double,
               onNavigateToDetail: (Int) -> Unit,
               onNavigateToCart: () -> Unit) {

    val totalText = String.format("%.2f", total)

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Row(modifier =  Modifier.fillMaxWidth().padding(20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Lista de productos", Modifier.weight(2f))
                        Row (modifier =  Modifier.fillMaxWidth().weight(1f),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("$totalText €", fontSize = 16.sp)
                            Spacer(Modifier.width(20.dp))
                            IconButton(onClick = { onNavigateToCart() }) {
                                Icon(
                                    imageVector = Icons.Filled.ShoppingCart,
                                    contentDescription = "Carrito"
                                )
                            }
                        }
                    }
                }
            )}
    ) { contentPadding ->
        LazyColumn (modifier = Modifier.padding(contentPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(products) {
                product ->  ProductListComponent(product = product,
                                        onClick = { id -> onNavigateToDetail(id)}
                )
            }
        }
    }
}