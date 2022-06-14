package com.test.meals.network

import retrofit2.Response

abstract class ApiSafeRequest {

  suspend fun <T:Any>executeRequest(apiRequest:suspend()->Response<T>):T{

     val response = apiRequest.invoke()


     if(response.isSuccessful){

       return response.body()!!


     } else {

       throw (Exception("Something went wrong!"))
     }
  }


}