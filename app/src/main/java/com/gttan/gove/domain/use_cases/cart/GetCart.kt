package com.gttan.gove.domain.use_cases.cart

import com.gttan.gove.domain.model.CartItem
import com.gttan.gove.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCart @Inject constructor(
    private val cartRepository: CartRepository
) {
    operator fun invoke(): Flow<List<CartItem>> {
        return cartRepository.getCart()
    }
}
