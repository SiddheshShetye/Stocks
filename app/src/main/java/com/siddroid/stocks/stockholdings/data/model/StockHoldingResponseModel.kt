package com.siddroid.stocks.stockholdings.data.model

data class StockHoldingResponseModel(
    val client_id: String,
    val `data`: List<Data>,
    val error: Any,
    val response_type: String,
    val timestamp: Long
)

data class Data(
    val avg_price: String,
    val close: Double,
    val cnc_used_quantity: Int,
    val collateral_qty: Int,
    val collateral_type: String,
    val collateral_update_qty: Int,
    val company_name: String,
    val haircut: Double,
    val holdings_update_qty: Int,
    val isin: String,
    val ltp: Double,
    val product: String,
    val quantity: Int,
    val symbol: String,
    val t1_holding_qty: Int,
    val token_bse: String,
    val token_nse: String,
    val withheld_collateral_qty: Int,
    val withheld_holding_qty: Int
) {
    fun currentValue() = ltp * quantity
    fun investmentValue() = avg_price.toFloat() - quantity
    fun pnl() = currentValue() - investmentValue()
}