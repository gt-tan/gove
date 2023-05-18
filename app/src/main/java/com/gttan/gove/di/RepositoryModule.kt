package com.gttan.gove.di

import com.gttan.gove.data.remote.repository.CartRepositoryImpl
import com.gttan.gove.data.remote.repository.CategoryRepositoryImpl
import com.gttan.gove.data.remote.repository.ProductRepositoryImpl
import com.gttan.gove.domain.repository.CartRepository
import com.gttan.gove.domain.repository.CategoryRepository
import com.gttan.gove.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository

    @Binds
    @Singleton
    abstract fun provideCartRepository(cartRepositoryImpl: CartRepositoryImpl): CartRepository

    @Binds
    @Singleton
    abstract fun provideCategoryRepository(categoryRepositoryImpl: CategoryRepositoryImpl): CategoryRepository
}
