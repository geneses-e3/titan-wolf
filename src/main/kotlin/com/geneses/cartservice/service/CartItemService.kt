package com.geneses.cartservice.service

import com.geneses.cartservice.model.Cart
import com.geneses.cartservice.model.CartItem

interface CartItemService {
    fun createCartItem(cartItem: CartItem): CartItem
    fun getCartItemsByCart(cartId: String): List<CartItem>
    fun getCartItemById(id: String): CartItem?
    fun updateCartItem(id: String, cartItem: CartItem): CartItem?
    fun removeCartItem(id: String)
}