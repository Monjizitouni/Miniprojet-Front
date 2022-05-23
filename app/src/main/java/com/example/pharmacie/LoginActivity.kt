package com.example.pharmacie

import android.content.ContentValues.TAG
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import androidx.core.content.edit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.pharmacie.models.User
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.FirebaseApp.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.ResponseBody
import tn.esprit.lolretrofit.utils.ApiInterface



class LoginActivity : AppCompatActivity() {

    lateinit var txtLogin: EditText
    lateinit var txtLayoutEmail: TextInputLayout
    lateinit var textInputEmail: TextInputLayout
    lateinit var txtPassword: EditText
    lateinit var textInputPassword: TextInputLayout
    lateinit var btnLogin: Button
    lateinit var  sharedpreferences : SharedPreferences
    private lateinit var mSharedPref: SharedPreferences
    val auth = FirebaseAuth.getInstance()
    var isRemembered = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        sharedpreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        isRemembered = mSharedPref.getBoolean("CHECKBOX",false)
        txtLogin = findViewById(R.id.editTextEmail)
        textInputEmail = findViewById(R.id.textInputEmail)


        txtPassword = findViewById(R.id.editTextPassword)
        textInputPassword= findViewById(R.id.textInputPassword)



        btnLogin = findViewById(R.id.cirLoginButton)

        /*if ( isRemembered) {
            Toast.makeText(this,"rember is not checked ", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Profille::class.java)
            startActivity(intent)
            finish()


        }else{
            val nameuser : String =txtLogin.text.toString()
            val password : String =txtPassword.text.toString()
            val editor : SharedPreferences.Editor=sharedpreferences.edit()
            editor.putString("username",nameuser)
            editor.putString("Password", password)
            editor.apply()


            Toast.makeText(this,"Information saved", Toast.LENGTH_SHORT).show()

             intent = Intent(this, Profille::class.java)
            startActivity(intent)
            finish()
        }*/




        btnLogin.setOnClickListener{

                        doLogin()
        }

        btn_forget_password.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Forget Password")
            val view = layoutInflater.inflate(R.layout.dialog_forget_password,null)
            val username = view.findViewById<EditText>(R.id.et_username)
            builder.setView(view)
            builder.setPositiveButton("Reset", DialogInterface.OnClickListener { _ ,_ ->
                forgetPassword(username)
            })
            builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { _ ,_ ->  })
            builder.show()
        }

    }

    private fun forgetPassword(username : EditText){
        if (username.text.toString().isEmpty()){

            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(username.text.toString()).matches()){

            return
        }

        auth.sendPasswordResetEmail(username.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this,"Email sent.",Toast.LENGTH_SHORT)
                }
    }}


    private fun doLogin() {
        if (!validate()) {


        } else {
            Log.e("username",txtLogin.text.toString())
            Log.e("password",txtPassword.text.toString())


            val apiInterface = ApiInterface.create()
            apiInterface.seConnecter(txtLogin.text.toString(), txtPassword.text.toString())
                .enqueue(object : Callback<User>{
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

                    override fun onResponse(call: Call<User>, response: Response<User>) {

                        val user = response.body()
                        Log.d("response", user.toString())
                        if (user != null) {
                            if (user.email == null) {





                                Toast.makeText(
                                    this@LoginActivity,
                                    "user not found",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()


                            } else {
                                mSharedPref.edit {
                                    putString("username", user.username)
                                    putString("email", user.email)
                                    putString("phone", user.phone)
                                    putString("password", user.password)
                                    putString("avatar", user.avatar)
                                        .commit()


                                }

                                Toast.makeText(
                                    this@LoginActivity,
                                    "user Success",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                startActivity(
                                    Intent(
                                        this@LoginActivity,
                                        Profille::class.java
                                    )
                                )
                                var test = mSharedPref.getString("avatar", "avatar")
                                Log.d("avatar",test.toString())


                            }

                        }

                        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    }


                    override fun onFailure(call: Call<User>, t: Throwable) {
                        Toast.makeText(
                            this@LoginActivity,
                            "Connexion error!",
                            Toast.LENGTH_SHORT
                        )
                            .show()



                        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    }

                })


        }
    }


        fun onLoginClick(View: View?) {
            startActivity(Intent(this, RegisterActivity::class.java))
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