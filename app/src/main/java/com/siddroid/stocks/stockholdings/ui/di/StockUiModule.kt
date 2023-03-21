package com.siddroid.stocks.stockholdings.ui.di

import com.siddroid.stocks.stockholdings.ui.StockHoldingAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class StockUiModule {

    @Provides
    @ActivityScoped
    fun providesStockHolderAdapter(): StockHoldingAdapter {
        return StockHoldingAdapter()
    }
}