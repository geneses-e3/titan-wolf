package com.geneses.cartservice.service

import com.geneses.cartservice.model.Cart

interface CartService {
    fun createCart(cart: Cart): Cart
    fun getCartByUserId(userId: String): Cart?
    fun updateCart(userId: String, cart: Cart): Cart?
    fun deleteCart(id: String)
}