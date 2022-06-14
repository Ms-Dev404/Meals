package com.test.meals.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.meals.util.AppCoroutine
import com.test.meals.model.LoginResponse
import com.test.meals.model.MealsResponse
import com.test.meals.ui.AppRepository


class AppViewModel(private val repository: AppRepository?):ViewModel() {

 private val _loginResponse = MutableLiveData<LoginResponse>()
 val loginResponse: LiveData<LoginResponse> get() = _loginResponse

 private val _mealResponse = MutableLiveData<MealsResponse>()
 val mealsResponse: LiveData<MealsResponse> get() = _mealResponse


  fun signIn(username:String,password:String) {

   AppCoroutine.run {

    repository?.let {

     _loginResponse.postValue(repository.signIn(username,password))

    } ?: Log.e("TAG", "AppViewModel call failed!")

   }
  }

  fun getMealsList(token:String,userId:Int,langId:String){

   AppCoroutine.run {

     repository?.let {

      _mealResponse.postValue(it.mealsList(token, langId, userId))

     }

   }

  }


}
