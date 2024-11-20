package com.geneses.cartservice.service

import com.geneses.cartservice.model.Cart
import com.geneses.cartservice.repository.CartRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CartServiceImpl @Autowired constructor(private val cartRepository: CartRepository) :CartService {
    override fun createCart(cart: Cart): Cart {
        return cartRepository.save(cart)
    }

    override fun getCartByUserId(userId: String): Cart? {
        return cartRepository.findByUserId(userId)
    }

    override fun updateCart(userId: String, cart: Cart): Cart? {
        val existingCart = cartRepository.findByUserId(userId)
        return if (existingCart != null ) {
            val updatedCart = existingCart.copy(
                totalPrice = cart.totalPrice,
                totalQuantity = cart.totalQuantity,
                updatedAt = System.currentTimeMillis()
            )

            cartRepository.save(updatedCart)
        } else {null}
    }

    override fun deleteCart(id: String) {
        return cartRepository.deleteById(id)
    }
}