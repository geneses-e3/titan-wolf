package com.geneses.cartservice.dto

data class CartItemDTO(
    val productId: String,
    val cartId: String,
    val quantity: Int = 1,
    val unitPrice: Double,
    val totalPrice: Double = quantity * unitPrice,
)
