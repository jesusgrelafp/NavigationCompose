package com.example.navigationcompose.data

import androidx.annotation.DrawableRes

data class Product(
    val id: Int,
    val title: String,
    val description: String = "",
    val category: String = "",
    val stock: Int = 0,
    val price: Double = 0.0,
    val sku: String = "",
    val availabilityStatus: String = "",
    @DrawableRes val image: Int = 0,
    val thumbnail: String = ""
)
