package tn.esprit.lolretrofit.utils

import android.widget.ImageView
import android.widget.Spinner
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.pharmacie.models.User
import com.example.pharmacie.models.Pharm
import retrofit2.http.*
import java.io.File

interface ApiInterface {

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("login")
    fun seConnecter(@Field("usename") login: String, @Field("password") password: String):Call<User>
    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("register")
    fun register(@Field("username") username: String, @Field("email") email: String, @Field("phone") phone: String, @Field("password") password: String,@Field("avatar") avatar: String): Call<User>



    companion object {

        var BASE_URL = "http://192.168.246.1:3000/api/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }




    }
