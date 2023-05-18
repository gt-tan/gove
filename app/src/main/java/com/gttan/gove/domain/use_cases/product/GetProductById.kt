package com.gttan.gove.domain.use_cases.product

import com.gttan.gove.domain.model.Product
import com.gttan.gove.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductById @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(id: Int): Result<Product> {
        return productRepository.getProductById(id)
    }
}
