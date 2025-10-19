package com.example.navigationcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.navigationcompose.data.DataSource
import com.example.navigationcompose.data.Product
import com.example.navigationcompose.model.ProductsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ProductsUiState())
    val uiState: StateFlow<ProductsUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = ProductsUiState(products = DataSource.products)
    }

    fun getProductById(id: Int): Product {
        return _uiState.value.products.firstOrNull { it.id == id }
            ?: Product(id = id, title = "Producto no encontrado")
    }
}