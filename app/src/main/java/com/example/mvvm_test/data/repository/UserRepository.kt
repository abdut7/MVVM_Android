package com.example.mvvm_test.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.mvvm_test.data.network.API
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun userLogIn(strName: String, strPassword: String): MutableLiveData<String> {
        val logInResponse = MutableLiveData<String>()
        val objUserLogin= JsonObject()
        objUserLogin.addProperty("strName",strName)
        objUserLogin.addProperty("strPassword",strPassword)
        API().userLogIn("application/json",objUserLogin).enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                logInResponse.value = t?.message
            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                if (response != null) {
                    if (response.isSuccessful) {
                        logInResponse.value = response.body()?.string()
                    } else {
                        logInResponse.value = response.errorBody()?.string()

                    }
                }
            }

        })
        return logInResponse
    }
}