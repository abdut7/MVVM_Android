package com.example.mvvm_test.ui.auth

import androidx.lifecycle.MutableLiveData

interface AuthListner {
    fun onStarted()
    fun onSuccess(logInResponse: MutableLiveData<String>)
    fun onFailiur(strMessage:String)
}