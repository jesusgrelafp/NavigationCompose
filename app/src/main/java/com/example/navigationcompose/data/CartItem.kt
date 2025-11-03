package com.example.navigationcompose.data

import androidx.annotation.DrawableRes

data class CartItem(
    val id: Int,
    val title: String,
    @DrawableRes val image: Int = 0,
    val price: Double,
    val quantity: Int = 1
)