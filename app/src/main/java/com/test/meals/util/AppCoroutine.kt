package com.test.meals.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object AppCoroutine {

 fun run(execute:suspend ()->Unit)= CoroutineScope(Dispatchers.IO).launch{

   execute()
}

}