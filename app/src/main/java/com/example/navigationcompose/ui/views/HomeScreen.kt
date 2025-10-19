package com.example.navigationcompose.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.navigationcompose.data.Product
import com.example.navigationcompose.ui.components.ProductListComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(products: List<Product>,
               onNavigateToDetail: (Int) -> Unit) {

    Scaffold (
        topBar = {
            TopAppBar(title = {Text("Lista de productos")} )
        }
    ) { contentPadding ->
        LazyColumn (modifier = Modifier.padding(contentPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(products) {
                product ->  ProductListComponent( product = product,
                                                    onClick = { id -> onNavigateToDetail(id) }
                )
            }
        }
    }
}