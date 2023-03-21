package com.siddroid.stocks.stockholdings.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siddroid.stocks.R
import com.siddroid.stocks.core.Failure
import com.siddroid.stocks.core.Success
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val stocksViewModel by viewModels<StockHoldingViewModel>()
    @Inject lateinit var adapter: StockHoldingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvHoldings = findViewById<RecyclerView>(R.id.rvHoldings)
        rvHoldings.layoutManager = LinearLayoutManager(this)
        rvHoldings.adapter = adapter
        rvHoldings.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        stocksViewModel.getStockHoldings()
        loadData()
    }

    private fun loadData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                stocksViewModel.responseState.collect {
                    when(it) {
                        is Success -> {
                            adapter.updateData(it.data.data)
                        }
                        is Failure -> {

                        }
                        else -> {

                        }
                    }
                }
            }
        }
    }
}