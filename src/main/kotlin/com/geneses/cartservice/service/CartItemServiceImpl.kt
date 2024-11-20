package com.geneses.cartservice.service

import com.geneses.cartservice.model.CartItem
import com.geneses.cartservice.repository.CartItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CartItemServiceImpl @Autowired constructor(
    private val cartItemRepo: CartItemRepository,
):CartItemService {
    override fun createCartItem(cartItem: CartItem): CartItem {
        return cartItemRepo.save(cartItem)
    }

    override fun getCartItemsByCart(cartId: String): List<CartItem> {
        return cartItemRepo.findCartItemsByCartId(cartId)
    }

    override fun getCartItemById(id: String): CartItem? {
        return cartItemRepo.findCartItemById(id)
    }

    override fun updateCartItem(id: String, cartItem: CartItem): CartItem? {
        val existingCartItem = cartItemRepo.findCartItemById(id)
        return if (existingCartItem != null) {
            val updatedCartItem = existingCartItem.copy(
                productId = cartItem.productId,
                quantity = cartItem.quantity,
                totalPrice = cartItem.totalPrice,
                cartId = cartItem.cartId,
                updatedAt = System.currentTimeMillis()
            )
            cartItemRepo.save(updatedCartItem)
        } else {null}
    }

    override fun removeCartItem(id: String) {
        return cartItemRepo.deleteById(id)
    }

}