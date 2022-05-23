package com.example.pharmacie

import CustomAdapter
import android.content.SharedPreferences
import android.graphics.Picture
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList

//const val PREF_NAME = "DATA_CV_PREF"

class ProfileActivity : AppCompatActivity() {
//    private  var imageView3 : CircleImageView?=null
//    private lateinit var mSharedPref: SharedPreferences
//    lateinit var textname : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

//        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
//        textname = findViewById(R.id.username)
//
//
//        imageView3 = findViewById(R.id.imageView3)
//        val usename = mSharedPref.getString("email", "email")
//        textname.text = usename
//        val filename2 = mSharedPref.getString("avatar", "avatar")
//        if (filename2 != null) {
//            Log.e("filename2",filename2)
//        }
//        val path = "https://firebasestorage.googleapis.com/v0/b/pharmacie-cef9a.appspot.com/o/images%2F"+filename2+"?alt=media"
//        Glide.with(this)
//            .load(path)
//            .into(imageView3)


        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)


        recyclerview.layoutManager = LinearLayoutManager(this)


        val data = ArrayList<ItemsViewModel>()
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)



        data.add(ItemsViewModel(R.drawable.pic_1, "Item "))
        data.add(ItemsViewModel(R.drawable.pic_2, "Item " ))
        data.add(ItemsViewModel(R.drawable.pic_3, "Item " ))


        // This will pass the ArrayList to our Adapter
       /* val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter*/
    }
}