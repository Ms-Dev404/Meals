package com.test.meals.ui

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.test.meals.viewmodel.ViewModelFactory
import com.test.meals.databinding.ActivityLoginBinding
import com.test.meals.viewmodel.AppViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var pDialog:ProgressDialog
    private val signupText= "Don't have an Account? Sign Up"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pDialog = ProgressDialog(this)
        pDialog.setMessage("Validating...")

        supportActionBar?.let {

            it.hide()
        }

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val factory = ViewModelFactory()
        val v = ViewModelProvider(this,factory)[AppViewModel::class.java]
        binding.apply {


            tvSignUp.text =signupText

            btnLogin.setOnClickListener {

              val userName = edUsername.text.toString().trim()
              val password = edPassword.text.toString().trim()

                if(userName.isNotEmpty() && password.isNotEmpty()){

                 v.signIn(userName,password)

                    if(!pDialog.isShowing) {
                        pDialog.show()
                    }

                }else{

                    Toast.makeText(this@LoginActivity, "All field required!", Toast.LENGTH_SHORT).show()
                }

            }
        }

       v.loginResponse.observe(this) { data ->

             if (pDialog.isShowing){

                 pDialog.cancel()
             }

             if(data.status){

              val token = "Bearer "+data.user.bearerToken

              navigate(data.user.id,token)

             }

           Toast.makeText(this, data.message, Toast.LENGTH_SHORT).show()
        }


    }

    private fun navigate(userId:Int,bearerToken:String){

      val intent = Intent(this, HomeActivity::class.java)
      intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
      intent.putExtra("USERID",userId)
      intent.putExtra("TOKEN",bearerToken)
      startActivity(intent)
    }
}