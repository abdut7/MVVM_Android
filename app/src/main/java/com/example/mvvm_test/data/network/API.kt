package com.example.mvvm_test.data.network

import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface API {
    @POST("login_user")
    fun userLogIn(
        @Header("Content-Type")strContentType:String,
        @Body userlogin: JsonObject
    ): Call<ResponseBody>

    companion object {
        operator fun invoke(): API {
            return Retrofit.Builder()
                .baseUrl("http://3.7.150.37:3001/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API::class.java)
        }
    }
}