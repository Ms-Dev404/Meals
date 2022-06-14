package com.test.meals.model

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("id") val id:Int, @SerializedName("access_token") val bearerToken:String)
