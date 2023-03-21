package com.siddroid.stocks.stockholdings.data.di

import com.siddroid.stocks.stockholdings.data.StockHoldingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StockHoldingDataModule {

    @Provides
    @Singleton
    fun provideStockHoldingService(retrofit: Retrofit): StockHoldingService {
        return retrofit.create(StockHoldingService::class.java)
    }
}