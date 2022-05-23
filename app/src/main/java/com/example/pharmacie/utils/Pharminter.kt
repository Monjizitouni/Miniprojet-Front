package com.example.pharmacie.utils

import com.example.pharmacie.models.Pharm
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST


interface Pharminter {
    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("registerpharm")

    fun registerpharm(@Field("username") username: String, @Field("email") email: String, @Field("phone") phone: String, @Field("password") password: String, @Field("idu") idu: String, @Field("region")  Spinner: String): Call<Pharm>
    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("loginpharm")
    fun Loginpharm(@Field("logname") login: String, @Field("password") password: String): Call<Pharm>


    companion object {

        var BASE_URL = "http://192.168.246.1:3000/api/"

        fun create() : Pharminter {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(Pharminter::class.java)
        }
    }

}