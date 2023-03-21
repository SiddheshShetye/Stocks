package com.siddroid.stocks.stockholdings.domain

import com.siddroid.stocks.core.Failure
import com.siddroid.stocks.core.Response
import com.siddroid.stocks.core.Success
import com.siddroid.stocks.stockholdings.data.model.StockHoldingResponseModel
import javax.inject.Inject

class StockHoldingUseCaseImpl @Inject constructor(private val stocksRepository: StockHoldingRepository): StockHoldingUseCase {
    override suspend fun invoke(): Response<StockHoldingResponseModel> {
        return stocksRepository.fetchStockHoldings();
    }
}