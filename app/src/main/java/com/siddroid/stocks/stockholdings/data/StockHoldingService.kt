package com.siddroid.stocks.stockholdings.data

import com.siddroid.stocks.stockholdings.data.model.StockHoldingResponseModel
import retrofit2.http.GET
import retrofit2.http.Headers

interface StockHoldingService {
    @Headers("Content-Type:application/json; charset=UTF-8")
    @GET("6d0ad460-f600-47a7-b973-4a779ebbaeaf")
    suspend fun getStockHoldings(): retrofit2.Response<StockHoldingResponseModel>
}