package com.example.pharmacie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class sign_up_trans : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_trans)
    }
    fun onSigninClick(View: View?) {
        startActivity(Intent(this, sign_in_trans::class.java))
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay)
        finish()
    }
}