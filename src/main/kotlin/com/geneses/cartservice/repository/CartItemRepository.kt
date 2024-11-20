package com.geneses.cartservice.repository

import com.geneses.cartservice.model.CartItem
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CartItemRepository: MongoRepository<CartItem, String> {
    fun findCartItemById(id: String): CartItem?
    fun findCartItemsByCartId(cartId: String): List<CartItem>
}