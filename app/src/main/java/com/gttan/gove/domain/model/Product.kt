package com.gttan.gove.domain.model

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val image: String,
    val price: Double,
    val rating: Rating,
)
