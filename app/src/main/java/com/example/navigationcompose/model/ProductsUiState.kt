package com.example.navigationcompose.model
import com.example.navigationcompose.data.Product

data class ProductsUiState (
    val products: List<Product> = emptyList(),
)