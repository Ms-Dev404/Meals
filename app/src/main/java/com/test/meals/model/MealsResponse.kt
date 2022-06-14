package com.test.meals.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MealsResponse(@SerializedName("status") @Expose val status:Boolean, @SerializedName("message") @Expose val message:String,@SerializedName("data")@Expose val meal:Meal) {

}