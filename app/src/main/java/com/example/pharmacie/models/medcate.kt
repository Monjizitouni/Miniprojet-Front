package com.example.pharmacie.models

import com.google.gson.annotations.SerializedName

data class medcate(
    @SerializedName("name") var name :String,
    @SerializedName("description") var description :  String,
    @SerializedName("prix") var prix : String,

    @SerializedName("photo") var photo: String,
    @SerializedName("categorie") var categorie : String
    )
