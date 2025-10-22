package com.example.navigationcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.navigationcompose.data.CartItem
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

    fun addToCart(product: Product, quantity: Int) {
        // Copiamos la lista actual a una mutable
        val currentCart = _uiState.value.cartItems.toMutableList()

        // Buscamos si ya hay un item con el mismo producto
        val existingItemIndex = currentCart.indexOfFirst { it.id == product.id }

        if (existingItemIndex != -1) {
            // Si existe, creamos un nuevo CartItem con la cantidad actualizada
            val updatedItem = currentCart[existingItemIndex].copy(
                quantity = currentCart[existingItemIndex].quantity + quantity
            )
            currentCart[existingItemIndex] = updatedItem
        } else {
            // Si no existe, lo añadimos
            currentCart.add(
                CartItem(
                    id =  product.id,
                    title =  product.title,
                    image =  product.image,
                    price = product.price,
                    quantity = quantity
                )
            )
        }

        // Actualizamos el estado
        _uiState.value = _uiState.value.copy(cartItems = currentCart)
    }

    fun removeFromCart(id: Int) {
        val updatedCart = _uiState.value.cartItems.filter { it.id != id }
        _uiState.value = _uiState.value.copy(cartItems = updatedCart)
    }

}