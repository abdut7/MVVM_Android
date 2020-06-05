package com.example.mvvm_test.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

fun Context.showToast(strMessage:String){
Toast.makeText(this,strMessage,Toast.LENGTH_LONG).show()
}

fun ProgressBar.show(){
    visibility=View.VISIBLE
}

fun  ProgressBar.hide(){
    visibility=View.GONE
}