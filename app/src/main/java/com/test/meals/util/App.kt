package com.test.meals.util

import android.app.Application
import com.test.meals.ui.AppRepository
import com.test.meals.network.ApiService
import com.test.meals.network.RetrofitBuilder

class App:Application() {

    companion object{

        var appRepository: AppRepository?=null
    }

    private var apiService: ApiService?=null


    override fun onCreate() {
        super.onCreate()

        apiService = apiService?: RetrofitBuilder.build()!!.create(ApiService::class.java)

        appRepository = appRepository ?: AppRepository(apiService!!)
    }
}