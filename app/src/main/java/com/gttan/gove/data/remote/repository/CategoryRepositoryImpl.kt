package com.gttan.gove.data.remote.repository

import com.gttan.gove.data.remote.service.StoreApi
import com.gttan.gove.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val storeApi: StoreApi
) : CategoryRepository {
    override suspend fun getCategories(): Result<List<String>> {
        return try {
            Result.success(
                storeApi.getCategories()
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
