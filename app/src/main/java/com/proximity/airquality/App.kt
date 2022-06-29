package com.proximity.airquality

import android.app.Activity
import android.app.Application
import com.proximity.airquality.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

class App : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()


        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        else Timber.plant(Timber.DebugTree())

        AppInjector.init(this)
    }

    override fun androidInjector(): AndroidInjector<Any>? = dispatchingAndroidInjector
}