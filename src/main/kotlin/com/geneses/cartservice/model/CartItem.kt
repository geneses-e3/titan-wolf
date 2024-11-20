package com.geneses.cartservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "cartItems")
data class CartItem(
    @Id
    val id: String? = null,
    val productId: String,
    val cartId: String,
    val quantity: Int = 1,
    val unitPrice: Double,
    val totalPrice: Double = quantity * unitPrice,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
)
