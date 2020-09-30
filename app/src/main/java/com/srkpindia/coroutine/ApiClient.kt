package com.srkpindia.coroutine

import myInterface
import myInterface.Companion.Base_URl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class ApiClient  {

     private val timeUnit = OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()


    @Inject
    constructor()

    fun getClient() : myInterface {
        return Retrofit.Builder()
            .baseUrl(Base_URl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(timeUnit)
            .build()
            .create(myInterface::class.java)
    }

}