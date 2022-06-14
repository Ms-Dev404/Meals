package com.test.meals.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(@SerializedName("status") @Expose val status:Boolean,@SerializedName("message") @Expose val message:String
,@SerializedName("user") @Expose val user:User) {

}
