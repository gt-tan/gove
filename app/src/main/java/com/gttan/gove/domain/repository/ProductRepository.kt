package com.gttan.gove.domain.repository

import com.gttan.gove.domain.model.Product

interface ProductRepository {

    suspend fun getProducts(): Result<List<Product>>

    suspend fun getProductById(id: Int): Result<Product>
}
