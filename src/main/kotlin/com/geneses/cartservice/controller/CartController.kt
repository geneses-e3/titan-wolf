package com.geneses.cartservice.controller

import com.geneses.cartservice.dto.CartDTO
import com.geneses.cartservice.model.Cart
import com.geneses.cartservice.service.CartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/carts")
class CartController @Autowired constructor(private val cartService: CartService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCart(@RequestBody cart: Cart): Cart {
        return cartService.createCart(cart)
    }

    @GetMapping("/user/{userId}")
    fun getCartByUserId(@PathVariable userId: String): CartDTO? {
        val cart = cartService.getCartByUserId(userId)
        return cart?.let {
            CartDTO(userId = it.userId, totalPrice = it.totalPrice, totalQuantity = it.totalQuantity)
        } ?: throw RuntimeException("Cart not found")
    }

    @PutMapping("/{userId}")
    fun updateCart(@PathVariable userId: String, @RequestBody cart: Cart): Cart? {
        return cartService.updateCart(userId, cart)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCart(@PathVariable id: String) {
        cartService.deleteCart(id)
    }
}