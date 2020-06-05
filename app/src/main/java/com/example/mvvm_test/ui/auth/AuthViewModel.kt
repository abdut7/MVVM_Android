package com.example.mvvm_test.ui.auth

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvm_test.data.repository.UserRepository

class AuthViewModel : ViewModel() {
    var strEmail: String? = null
    var strPassword: String? = null
    var authListner:AuthListner?=null
    fun onLogInButtonClick(view: View) {
        authListner?.onStarted()
        if (strEmail.isNullOrEmpty() || strPassword.isNullOrEmpty()) {
            //Error Message
            authListner?.onFailiur("INVALID_EMAIL_PASS")
            return
        }
        val logInResponse= UserRepository().userLogIn(strEmail!!,strPassword!!)
        authListner?.onSuccess(logInResponse)
    }
}