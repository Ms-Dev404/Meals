package com.test.meals.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.meals.util.App.Companion.appRepository


class ViewModelFactory:ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(AppViewModel::class.java)){

           return AppViewModel(appRepository) as T
        }

        throw(Throwable("Unknown class"))
    }
}