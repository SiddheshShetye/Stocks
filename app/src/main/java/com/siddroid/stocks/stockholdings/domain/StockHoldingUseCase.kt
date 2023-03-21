package com.siddroid.stocks.stockholdings.domain

import com.siddroid.stocks.core.Response
import com.siddroid.stocks.stockholdings.data.model.StockHoldingResponseModel

interface StockHoldingUseCase {
    suspend fun invoke(): Response<StockHoldingResponseModel>
}