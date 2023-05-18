package com.gttan.gove.data.remote.repository

import com.gttan.gove.data.mapper.ProductMapper
import com.gttan.gove.data.remote.service.StoreApi
import com.gttan.gove.domain.model.Product
import com.gttan.gove.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val storeApi: StoreApi,
    private val mapper: ProductMapper,
) : ProductRepository {
    override suspend fun getProducts(): Result<List<Product>> {
        return try {
            Result.success(
                mapper.mapFromEntityList(storeApi.getProducts())
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getProductById(id: Int): Result<Product> {
        return try {
            Result.success(
                mapper.mapFromEntity(storeApi.getProductById(id))
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
