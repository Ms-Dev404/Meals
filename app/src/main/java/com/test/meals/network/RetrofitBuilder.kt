package com.test.meals.network

import com.test.meals.util.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

    var retrofit: Retrofit? = null

    fun build(): Retrofit?{



        return Retrofit.Builder().baseUrl(Constants.URL).client(getClient()).addConverterFactory(
            GsonConverterFactory.create()) .build()


    }

    private fun getClient() = OkHttpClient.Builder().callTimeout(20, TimeUnit.SECONDS).readTimeout(20,
        TimeUnit.SECONDS).build()
}