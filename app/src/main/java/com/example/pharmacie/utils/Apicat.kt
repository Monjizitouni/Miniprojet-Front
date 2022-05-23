package com.example.pharmacie.utils

import com.example.pharmacie.models.categorie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface Apicat {
    @Headers("Accept: application/json")
    @GET("show")
    fun show (): Call<MutableList<categorie>>

companion object {

    var BASE_URL = "http://192.168.246.1:3000/catc/"

    fun create() : Apicat {

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(Apicat::class.java)
    }
}

}