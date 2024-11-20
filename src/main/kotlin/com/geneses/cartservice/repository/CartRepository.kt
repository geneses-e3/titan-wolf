package com.geneses.cartservice.repository

import com.geneses.cartservice.model.Cart
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CartRepository : MongoRepository<Cart, String> {
    fun findByUserId(userId: String): Cart?
    fun findCartById(id: String): Cart?
}