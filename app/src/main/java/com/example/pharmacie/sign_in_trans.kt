package com.example.pharmacie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class sign_in_trans : AppCompatActivity() {
    lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_trans)
        btnLogin = findViewById(R.id.buttonz)

        btnLogin.setOnClickListener{
            doLogin()
        }

    }

    private fun doLogin(){

        startActivity(
            Intent(
                this@sign_in_trans,
                Livreur::class.java
            )
        )



    }
    fun onSignupClick(View: View?) {
        startActivity(Intent(this, sign_up_trans::class.java))
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay)
        finish()
    }
}