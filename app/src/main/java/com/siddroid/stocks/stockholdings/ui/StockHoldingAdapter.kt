package com.siddroid.stocks.stockholdings.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.siddroid.stocks.R
import com.siddroid.stocks.stockholdings.data.model.Data

class StockHoldingAdapter: Adapter<StockHoldingAdapter.StockHoldingViewHolder>() {

    private val stockList = mutableListOf<Data>()

    class StockHoldingViewHolder(private val view: View): ViewHolder(view) {
        var symbol: TextView = view.findViewById(R.id.tvSymbols)
        var quantity: TextView = view.findViewById(R.id.tvQuantity)
        var ltp: TextView = view.findViewById(R.id.tvLtp)
        var pnl: TextView = view.findViewById(R.id.tvPL)

        fun bindData(data: Data) {
            symbol.text = data.symbol
            quantity.text = data.quantity.toString()
            ltp.text = data.ltp.toString()
            pnl.text = data.pnl().toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockHoldingViewHolder {
        return StockHoldingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_stock_holdomg, parent, false))
    }

    override fun getItemCount(): Int {
        return stockList.size
    }

    override fun onBindViewHolder(holder: StockHoldingViewHolder, position: Int) {
        holder.bindData(stockList[position])
    }

    fun updateData(stocks: List<Data>) {
        stockList.clear()
        stockList.addAll(stocks)
        notifyItemRangeChanged(0, stockList.size)
    }
}