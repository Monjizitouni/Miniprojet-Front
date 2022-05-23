/*package com.example.pharmacie.utils

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface MyAPIUP {
    @Multipart
    @POST("")
    fun uploadImage(
        @Part image: MultipartBody.Part,
        @Part("desc") desc: RequestBody
    ): Call<UploadResponse>

    companion object {
        operator fun invoke(): MyAPIUP {
            return Retrofit.Builder()
                .baseUrl("http://10.10.10.118/ImageUploader/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyAPIUP::class.java)
        }
}*/