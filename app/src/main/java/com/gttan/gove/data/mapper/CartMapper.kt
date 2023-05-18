package com.gttan.gove.data.mapper

import com.gttan.gove.data.remote.entity.CartItemEntity
import com.gttan.gove.data.remote.entity.ProductEntity
import com.gttan.gove.domain.model.CartItem
import com.gttan.gove.domain.util.Mapper
import javax.inject.Inject

class CartMapper @Inject constructor(
    private val productMapper: ProductMapper
) : Mapper<CartItemEntity, CartItem> {

    override fun mapFromEntity(entity: CartItemEntity): CartItem {
        return CartItem(
            product = productMapper.mapFromEntity(
                entity.product ?: ProductEntity()
            ),
            amount = entity.amount ?: 0,
        )
    }

    override fun mapToEntity(domainModel: CartItem): CartItemEntity {
        return CartItemEntity(
            product = productMapper.mapToEntity(domainModel.product),
            amount = domainModel.amount,
        )
    }

    fun mapFromEntityList(entities: List<CartItemEntity>): List<CartItem> {
        return entities.map { mapFromEntity(it) }
    }

}
