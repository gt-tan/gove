package com.gttan.gove.domain.repository

import com.gttan.gove.domain.model.CartItem
import com.gttan.gove.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun getCart(): Flow<List<CartItem>>

    fun addToCart(product: Product, amount: Int, onSuccess: () -> Unit)

    fun changeAmount(product: Product, amount: Int)

    fun clearCart()

    fun removeFromCart(product: Product)
}
