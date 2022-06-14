package com.test.meals.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Meal(@SerializedName("banners") @Expose val banners:ArrayList<Banner>,@SerializedName("meal_categories") @Expose val mealCategory:ArrayList<MealCategory>)
data class Banner(@SerializedName("id") @Expose val id:Int,@SerializedName("name") @Expose val name:String,@SerializedName("image") @Expose val imageUl:String)
data class MealCategory(@SerializedName("id") @Expose val id:Int,@SerializedName("name") @Expose val name:String,@SerializedName("image") @Expose val imageUl:String)