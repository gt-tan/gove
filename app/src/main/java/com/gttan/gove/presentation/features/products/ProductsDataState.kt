package com.gttan.gove.presentation.features.products

import com.gttan.gove.domain.model.Product

data class ProductsDataState(
    val isLoading: Boolean = true,
    val products: List<Product> = emptyList(),
    val error: String? = null
)
