package com.gttan.gove.domain.use_cases.category

import javax.inject.Inject

data class CategoryUseCases @Inject constructor(
    val getCategories: GetCategories
)
