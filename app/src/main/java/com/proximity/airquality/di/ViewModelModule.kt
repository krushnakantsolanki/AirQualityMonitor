package com.proximity.airquality.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.proximity.airquality.aqcitylist.ui.AQICityListViewModel
import com.proximity.airquality.aqdetail.ui.AQICityDetailViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AQICityListViewModel::class)
    abstract fun bindThemeViewModel(viewModel: AQICityListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AQICityDetailViewModel::class)
    abstract fun bindLegoSetsViewModel(viewModel: AQICityDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AQICityListViewModel::class)
    abstract fun bindLegoSetViewModel(viewModel: AQICityListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
