package com.siddroid.stocks.stockholdings.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siddroid.stocks.core.Failure
import com.siddroid.stocks.core.Response
import com.siddroid.stocks.stockholdings.data.model.StockHoldingResponseModel
import com.siddroid.stocks.stockholdings.domain.StockHoldingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockHoldingViewModel @Inject constructor(private val stockUsecase: StockHoldingUseCase): ViewModel() {

    private val _responseState = MutableStateFlow<Response<StockHoldingResponseModel>>(Failure(0, ""))
    val responseState: StateFlow<Response<StockHoldingResponseModel>> = _responseState.asStateFlow()

    fun getStockHoldings() {
        viewModelScope.launch {
            _responseState.value =  stockUsecase.invoke()
        }
    }

}