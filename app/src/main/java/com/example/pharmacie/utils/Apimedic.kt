package com.example.pharmacie.utils

import com.example.pharmacie.models.categorie
import com.example.pharmacie.models.medcate
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface Apimedic {
    @Headers("Accept: application/json")
    @GET("aff")
    fun show (): Call<MutableList<medcate>>

    companion object {

        var BASE_URL = "http://192.168.246.1:3000/medic/"

        fun create() : Apimedic {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(Apimedic::class.java)
        }
    }
}