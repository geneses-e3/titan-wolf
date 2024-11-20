package com.geneses.cartservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "carts")
data class Cart(
    @Id
    val id: String? = null,
    val userId: String,
    val totalQuantity: Int,
    val totalPrice: Double,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
)