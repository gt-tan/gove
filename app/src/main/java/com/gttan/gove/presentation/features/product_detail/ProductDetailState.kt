package com.gttan.gove.presentation.features.product_detail

import com.gttan.gove.domain.model.Product

data class ProductDetailState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val product: Product? = null,
    val amount: Int = 1,
)
