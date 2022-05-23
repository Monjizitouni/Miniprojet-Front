package com.example.pharmacie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.pharmacie.models.Pharm
import com.example.pharmacie.models.User
import com.example.pharmacie.utils.Pharminter
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tn.esprit.lolretrofit.utils.ApiInterface


class sign_in_pharm : AppCompatActivity() {

    lateinit var txtLogin: EditText

    lateinit var txtPassword: EditText

    lateinit var btnLogin: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_pharm)

        txtLogin = findViewById(R.id.editTextusername)

        txtPassword = findViewById(R.id.editTextpassword)

        btnLogin = findViewById(R.id.buttonsignin)

        btnLogin.setOnClickListener{
            doLogin()
        }

    }

    private fun doLogin() {
        if (!validate()) {


        } else {
            Log.d("username",txtLogin.text.toString())
            Log.d("password",txtPassword.text.toString())


            val apipharm = Pharminter.create()
            apipharm.Loginpharm(txtLogin.text.toString(), txtPassword.text.toString())
                .enqueue(object : Callback<Pharm> {
                    /*override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                        Log.d("erreur1",call.toString())
                        //handle error here
                    }

                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        //your raw string response
                        val stringResponse = response.body()?.string()
                        Log.d("waaaaaaaaa",stringResponse.toString())                        }

                })
            }*/

                    override fun onResponse(call: Call<Pharm>, response: Response<Pharm>) {

                        val pharm = response.body()
                        Log.d("response", pharm.toString())
                        if (pharm != null) {
                            if (pharm.email == null) {


                                Toast.makeText(
                                    this@sign_in_pharm,
                                    "user not found",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()


                            } else {

                                Toast.makeText(
                                    this@sign_in_pharm,
                                    "user Success",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                startActivity(
                                    Intent(
                                        this@sign_in_pharm,
                                        Pharmacien::class.java
                                    )
                                )


                            }

                        }

                        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    }


                    override fun onFailure(call: Call<Pharm>, t: Throwable) {
                        Toast.makeText(
                            this@sign_in_pharm,
                            "Connexion error!",
                            Toast.LENGTH_SHORT
                        )
                            .show()



                        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    }

                })


        }
    }




    fun onSignupClick(View: View?) {
        startActivity(Intent(this, sign_up_pharm::class.java))
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay)
        finish()
    }

    private fun validate(): Boolean {

        txtLogin.error = null
        txtPassword.error = null

        if (txtLogin.text!!.isEmpty()){

            return false
        }





        return true
    }
}