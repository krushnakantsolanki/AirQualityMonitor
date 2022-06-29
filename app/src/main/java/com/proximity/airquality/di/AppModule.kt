package com.proximity.airquality.di


import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@Module(includes = [ViewModelModule::class, CoreDataModule::class])
class AppModule {

//    @Singleton
//    @Provides
//    fun provideLegoService(@LegoAPI okhttpClient: OkHttpClient,
//            converterFactory: GsonConverterFactory
//    ) = provideService(okhttpClient, converterFactory, WebService::class.java)

//    @Singleton
//    @Provides
//    fun provideLegoSetRemoteDataSource(webService: WebService)
//            = LegoSetRemoteDataSource(webService)
//
//    @Singleton
//    @Provides
//    fun provideLegoThemeRemoteDataSource(webService: WebService)
//            = LegoThemeRemoteDataSource(webService)

  //  @LegoAPI
//    @Provides
//    fun providePrivateOkHttpClient(
//            upstreamClient: OkHttpClient
//    ): OkHttpClient {
//        return upstreamClient.newBuilder()
//                .addInterceptor(AuthInterceptor(BuildConfig.API_DEVELOPER_TOKEN)).build()
//    }

//    @Singleton
//    @Provides
//    fun provideDb(app: Application) = AppDatabase.getInstance(app)
//
//    @Singleton
//    @Provides
//    fun provideLegoSetDao(db: AppDatabase) = db.legoSetDao()
//
//
//    @Singleton
//    @Provides
//    fun provideLegoThemeDao(db: AppDatabase) = db.legoThemeDao()

    @CoroutineScropeIO
    @Provides
    fun provideCoroutineScopeIO() = CoroutineScope(Dispatchers.IO)


//    private fun createRetrofit(
//            okhttpClient: OkHttpClient,
//            converterFactory: GsonConverterFactory
//    ): Retrofit {
//        return Retrofit.Builder()
//                .baseUrl(WebService.ENDPOINT)
//                .client(okhttpClient)
//                .addConverterFactory(converterFactory)
//                .build()
//    }

//    private fun <T> provideService(okhttpClient: OkHttpClient,
//            converterFactory: GsonConverterFactory, clazz: Class<T>): T {
//        return createRetrofit(okhttpClient, converterFactory).create(clazz)
//    }
}
