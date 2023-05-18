package com.gttan.gove.domain.use_cases.cart

import com.gttan.gove.domain.model.Product
import com.gttan.gove.domain.repository.CartRepository
import javax.inject.Inject

class RemoveFromCart @Inject constructor(
    private val cartRepository: CartRepository
) {
    operator fun invoke(product: Product) {
        cartRepository.removeFromCart(product)
    }
}
