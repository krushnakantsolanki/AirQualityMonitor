package com.proximity.airquality.di


import com.proximity.airquality.aqcitylist.ui.AQICityListFragment
import com.proximity.airquality.aqdetail.ui.AQICityDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeCityListFragment(): AQICityListFragment

    @ContributesAndroidInjector
    abstract fun contributeCityDetailFragment(): AQICityDetailFragment

}
