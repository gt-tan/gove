package com.gttan.gove.presentation.features.cart

import com.gttan.gove.domain.model.CartItem

data class CartDataState(
    val cartItems: List<CartItem> = emptyList(),
    val total: Double = 0.0
)
