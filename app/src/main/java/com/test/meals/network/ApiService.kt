package com.test.meals.network

import com.test.meals.util.Constants.LOGIN_ENDPOINT
import com.test.meals.util.Constants.MEALS_LIST
import com.test.meals.model.LoginResponse
import com.test.meals.model.MealsResponse
import retrofit2.Response
import retrofit2.http.*


interface ApiService {

 @FormUrlEncoded
 @POST(LOGIN_ENDPOINT)
  suspend fun loginApi(@Field("email")email:String,@Field("password")password:String,@Field("lang_id")lang:String,@Field("device_token")token:String):Response<LoginResponse>

 @FormUrlEncoded
 @POST(MEALS_LIST)
 suspend fun mealsListApi(@Header("Authorization")token: String, @Field("lang_id")langId:String, @Field("user_id")userId:Int):Response<MealsResponse>

}

