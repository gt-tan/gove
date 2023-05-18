package com.gttan.gove.domain.use_cases.cart

import com.gttan.gove.domain.repository.CartRepository
import javax.inject.Inject

class ClearCart @Inject constructor(
    private val cartRepository: CartRepository
) {
    operator fun invoke() {
        cartRepository.clearCart()
    }
}
