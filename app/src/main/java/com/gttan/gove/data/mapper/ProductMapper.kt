package com.gttan.gove.data.mapper

import com.gttan.gove.data.remote.entity.ProductEntity
import com.gttan.gove.data.remote.entity.RatingEntity
import com.gttan.gove.domain.model.Product
import com.gttan.gove.domain.util.Mapper
import javax.inject.Inject

class ProductMapper @Inject constructor(
    private val ratingMapper: RatingMapper
) : Mapper<ProductEntity, Product> {
    override fun mapFromEntity(entity: ProductEntity): Product {
        return Product(
            id = entity.id ?: 0,
            title = entity.title ?: "",
            description = entity.description ?: "",
            category = entity.category ?: "",
            image = entity.image ?: "",
            price = entity.price ?: 0.0,
            rating = ratingMapper.mapFromEntity(entity.rating ?: RatingEntity())
        )
    }

    override fun mapToEntity(domainModel: Product): ProductEntity {
        return ProductEntity(
            id = domainModel.id,
            title = domainModel.title,
            description = domainModel.description,
            category = domainModel.category,
            image = domainModel.image,
            price = domainModel.price,
            rating = ratingMapper.mapToEntity(domainModel.rating)
        )
    }

    fun mapFromEntityList(entities: List<ProductEntity>): List<Product> {
        return entities.map { mapFromEntity(it) }
    }
}
