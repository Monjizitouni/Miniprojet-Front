package com.example.pharmacie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var btndoc: Button
lateinit var btnliv: Button
lateinit var btncli: Button
class sign_up_trio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_trio)

        btndoc = findViewById(R.id.button9)
        btnliv = findViewById(R.id.buttonliv)
        btncli = findViewById(R.id.buttoncli)



        btndoc.setOnClickListener{
            dodoc()
        }
        btnliv.setOnClickListener{
            docliv()
        }
        btncli.setOnClickListener{
            docli()
        }
    }

    private fun docliv() {
        startActivity(
            Intent(
                this, sign_in_trans::class.java
            )
        )
    }

    private fun docli() {
        startActivity(
            Intent(
                this, LoginActivity::class.java
            )
        )
    }

    private fun dodoc() {

        startActivity(
            Intent(
                this, sign_in_pharm::class.java
            )
        )


    }
}
