package com.geneses.cartservice.dto


data class CartDTO(
    val userId: String,
    val totalQuantity: Int,
    val totalPrice: Double,
)