package com.example.pharmacie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.*
import com.example.pharmacie.models.Pharm
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Spinner
import com.example.pharmacie.utils.Pharminter
import tn.esprit.lolretrofit.utils.ApiInterface


class sign_up_pharm : AppCompatActivity() {

    lateinit var txtpharmname: EditText


    lateinit var txtEmail: EditText



    lateinit var txtphone: EditText


    lateinit var txtPassword: EditText

    lateinit var txtidu: EditText

    lateinit var Spinner: Spinner

    lateinit var btnSignup: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_pharm)

        Spinner = findViewById(R.id.spinner1)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.regions,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            Spinner.adapter = adapter
        }



        txtpharmname = findViewById(R.id.editTextpharmname)

        txtEmail = findViewById(R.id.editTextEmail)


        txtphone = findViewById(R.id.editTextPhone)


        txtPassword = findViewById(R.id.editTextPassword)

        txtidu = findViewById(R.id.editTextidu)








        btnSignup = findViewById(R.id.buttonsiup)



        btnSignup.setOnClickListener {
            doSignup()
        }
    }
    private fun doSignup() {
        if (!validate()) {



        }else {



            val apipharm = Pharminter.create()

            apipharm.registerpharm(
                txtpharmname.text.toString(),
                txtEmail.text.toString(),
                txtphone.text.toString(),
                txtPassword.text.toString(),
                txtidu.text.toString(),
                Spinner.selectedItem.toString()

            ).enqueue(object :
                Callback<Pharm> {

                override fun onResponse(call: Call<Pharm>, response: Response<Pharm>) {

                    val pharm = response.body()
                    Log.d("response", pharm.toString())
                    if (pharm != null) {
                        if (pharm.email == null && pharm.idu==null) {

                            Toast.makeText(
                                this@sign_up_pharm,
                                "email or idu  already exist",
                                Toast.LENGTH_SHORT
                            )
                                .show()



                        }else {
                            Toast.makeText(
                                this@sign_up_pharm,
                                "user Success",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            startActivity(
                                Intent(
                                    this@sign_up_pharm,
                                    WelcomeActivity::class.java
                                )
                            )

                        }
                    }


                    window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                }

                override fun onFailure(call: Call<Pharm>, t: Throwable) {
                    Toast.makeText(
                        this@sign_up_pharm,
                        "Connexion error!",
                        Toast.LENGTH_SHORT
                    )
                        .show()



                    window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                }

            })

            window.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            )


        }


    }


    fun onSigninClick(View: View?) {
        startActivity(Intent(this, sign_in_pharm::class.java))
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay)
        finish()

    }


    private fun validate(): Boolean {
        txtphone.error = null
        txtpharmname.error = null
        txtEmail.error = null
        txtPassword.error = null

        if (txtpharmname.text!!.isEmpty()){
            txtpharmname.error = "Name Required *"
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText().toString()).matches()) {
            txtEmail.setError("Please enter a Valid E-Mail Address!");
            return false
        }

        if (txtphone.text!!.isEmpty()){
            txtphone.error = "Phone Required *"
            return false
        }
        if (txtPassword.text!!.isEmpty()){
            txtPassword.error = "Password Required *"
            return false
        }else {


            return true
        }
    }
}