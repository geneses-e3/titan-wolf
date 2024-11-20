package com.geneses.cartservice.controller

import com.geneses.cartservice.dto.CartItemDTO
import com.geneses.cartservice.model.CartItem
import com.geneses.cartservice.service.CartItemService


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cartItems")
class CartItemController @Autowired constructor(private val itemService: CartItemService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCartItem(@RequestBody cartItem: CartItem) : CartItem {
        return itemService.createCartItem(cartItem)
    }

    @GetMapping("/{id}")
    fun getCartItemById(@PathVariable id: String): CartItemDTO? {
        val item = itemService.getCartItemById(id)
        return item?.let {
            CartItemDTO(
                productId = it.productId,
                cartId = it.cartId,
                quantity = it.quantity,
                unitPrice = it.unitPrice,
                totalPrice = it.totalPrice
            )
        } ?: throw RuntimeException("CartItem not found")
    }

    @PutMapping("/{id}")
    fun updateCartItem(@PathVariable id: String, @RequestBody cartItem: CartItem): CartItem? {
        return itemService.updateCartItem(id, cartItem)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCartItem(@PathVariable id: String) {
        itemService.removeCartItem(id)
    }
}