package com.gttan.gove.domain.use_cases.cart

import javax.inject.Inject

data class CartUseCases @Inject constructor(
    val getCart: GetCart,
    val addToCart: AddToCart,
    val increaseAmount: IncreaseAmount,
    val decreaseAmount: DecreaseAmount,
    val removeFromCart: RemoveFromCart,
    val clearCart: ClearCart,
)
