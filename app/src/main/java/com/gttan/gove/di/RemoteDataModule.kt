package com.gttan.gove.di

import com.gttan.gove.BuildConfig
import com.gttan.gove.data.remote.service.StoreApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Singleton
    @Provides
    fun provideStoreApi(): StoreApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

}
