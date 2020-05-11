package com.health.covid19Track.network

import com.health.covid19Track.utils.BASE_URL
import com.health.covid19Track.utils.BASE_URL_Country
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private var retrofit: Retrofit = RetrofitBuilder(BASE_URL)

    @JvmStatic
    fun <S> cteateService(serviceClass: Class<S>?): S {
        return retrofit.create(serviceClass)
    }
    @JvmStatic
      fun RetrofitBuilder(baseUrl: String): Retrofit {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit
    }
}


