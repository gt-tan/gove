package com.gttan.gove.domain.repository

interface CategoryRepository {
    suspend fun getCategories(): Result<List<String>>
}
