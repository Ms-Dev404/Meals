package com.test.meals.ui

import com.test.meals.network.ApiSafeRequest
import com.test.meals.network.ApiService

class AppRepository(val apiService: ApiService): ApiSafeRequest() {



 suspend fun signIn(userName:String,password:String)=executeRequest {   apiService.loginApi(userName,password,"en","sss")}
 suspend fun mealsList(token:String,langId:String, userId:Int)=executeRequest {   apiService.mealsListApi(token,langId,userId)}
}