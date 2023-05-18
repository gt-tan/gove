package com.gttan.gove.data.remote.repository

import com.gttan.gove.data.mapper.CartMapper
import com.gttan.gove.domain.model.CartItem
import com.gttan.gove.domain.model.Product
import com.gttan.gove.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val cartMapper: CartMapper,
) : CartRepository {
    override fun getCart(): Flow<List<CartItem>> {
        // TODO:
        return emptyList<List<CartItem>>().asFlow()
    }

    override fun addToCart(product: Product, amount: Int, onSuccess: () -> Unit) {
        // TODO:
    }

    override fun changeAmount(product: Product, amount: Int) {
        // TODO:
    }

    override fun clearCart() {
        // TODO:
    }

    override fun removeFromCart(product: Product) {
        // TODO:
    }
}
