package com.gttan.gove.data.remote.service

import com.gttan.gove.data.remote.entity.ProductEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreApi {

    @GET("products")
    suspend fun getProducts(): List<ProductEntity>

    @GET("products/categories")
    suspend fun getCategories(): List<String>

    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ): ProductEntity
}
