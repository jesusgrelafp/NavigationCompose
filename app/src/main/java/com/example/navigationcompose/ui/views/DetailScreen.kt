package com.example.navigationcompose.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navigationcompose.data.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  DetailScreen(product: Product,
                  onBack: () -> Unit
) {
    Scaffold (
        topBar = { TopAppBar(title = {Text("Detalle del producto")}) }
    ) { contentPadding ->
        Column (
            modifier = Modifier.padding(contentPadding).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Has seleccionado el producto: $product.id")
            Text("Que es: $product.title }")
            Spacer(modifier = Modifier.height(28.dp))
            Button(onClick = {onBack()} ){
                Text("Volver")
            }
        }
    }
}