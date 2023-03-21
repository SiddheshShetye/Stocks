package com.siddroid.stocks.stockholdings.data

import com.siddroid.stocks.core.BaseRepo
import com.siddroid.stocks.core.Response
import com.siddroid.stocks.stockholdings.data.model.StockHoldingResponseModel
import com.siddroid.stocks.stockholdings.domain.StockHoldingRepository
import javax.inject.Inject

class StockHoldingRepositoryImpl @Inject constructor(private val stockService: StockHoldingService): BaseRepo(), StockHoldingRepository {
    override suspend fun fetchStockHoldings(): Response<StockHoldingResponseModel> {
        return safeApiCall { stockService.getStockHoldings() }
    }
}