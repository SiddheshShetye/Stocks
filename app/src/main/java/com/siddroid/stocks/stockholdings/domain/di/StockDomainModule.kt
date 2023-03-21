package com.siddroid.stocks.stockholdings.domain.di

import com.siddroid.stocks.stockholdings.data.StockHoldingRepositoryImpl
import com.siddroid.stocks.stockholdings.domain.StockHoldingRepository
import com.siddroid.stocks.stockholdings.domain.StockHoldingUseCase
import com.siddroid.stocks.stockholdings.domain.StockHoldingUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StockDomainModule {

    @Binds
    @Singleton
    abstract fun provideStockRepository(repository: StockHoldingRepositoryImpl): StockHoldingRepository

    @Binds
    @Singleton
    abstract fun provideStockUseCase(useCase: StockHoldingUseCaseImpl): StockHoldingUseCase
}