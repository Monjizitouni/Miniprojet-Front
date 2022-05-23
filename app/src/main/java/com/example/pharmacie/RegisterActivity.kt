package com.example.pharmacie

import android.app.Activity.RESULT_OK
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.*
import com.example.pharmacie.models.User
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import de.hdodenhof.circleimageview.CircleImageView

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tn.esprit.lolretrofit.utils.ApiInterface
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*


class RegisterActivity : AppCompatActivity() {


    lateinit var txtName: EditText
    lateinit var txtLayoutName: TextInputLayout

    lateinit var txtEmail: EditText
    lateinit var txtLayoutEmail: TextInputLayout


    lateinit var txtphone: EditText
    lateinit var txtLayoutPhone: TextInputLayout

    lateinit var txtPassword: EditText
    lateinit var txtLayoutPaswword: TextInputLayout
    lateinit var btnSignup: Button
    lateinit var butimg: TextView




    lateinit var storage: FirebaseStorage
    val formater = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
    val now = Date()
    val fileName = formater.format(now)

    private var profilePic: CircleImageView? = null
    private var selectedImageUri: Uri? = null


    companion object{
         val IMAGE_REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        txtName = findViewById(R.id.editTextName)
        txtLayoutName = findViewById(R.id.textInputName)

        txtEmail = findViewById(R.id.editTextEmail)
        txtLayoutEmail = findViewById(R.id.textInputEmail)

        txtphone = findViewById(R.id.editTextMobile)
        txtLayoutPhone = findViewById(R.id.textInputPhone)

        txtPassword = findViewById(R.id.editTextPassword)
        txtLayoutPaswword = findViewById(R.id.textInputPassword)



        btnSignup = findViewById(R.id.cirRegisterButton)
        butimg = findViewById(R.id.btn_pick_img)
        profilePic = findViewById(R.id.img_save)

        storage = Firebase.storage



        btnSignup.setOnClickListener {
            doSignup()

        }
butimg.setOnClickListener{
    openGallery()


}

    }




    private fun uploadImage()
    {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Uploading Image ...")
        progressDialog.setCancelable(false)
        progressDialog.show()
        val storageReference = FirebaseStorage.getInstance().reference.child("images/$fileName")
        storageReference.putFile(selectedImageUri!!).
        addOnSuccessListener {
            profilePic!!.setImageURI(selectedImageUri)
            if(progressDialog.isShowing)
            {
                progressDialog.dismiss()
            }
            Toast.makeText(this,"Successfuly uploaded", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            if(progressDialog.isShowing)
            {
                progressDialog.dismiss()
            }
            Toast.makeText(this,"Sorry", Toast.LENGTH_SHORT).show()

        }
    }
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if(requestCode == 100 && resultCode == RESULT_OK)
    {
        selectedImageUri = data?.data!!
        profilePic!!.setImageURI(selectedImageUri)
    }
}
private fun openGallery() {
    val intent = Intent()
    intent.type = "image/*"
    intent.action = Intent.ACTION_GET_CONTENT
    startActivityForResult(intent,100)
}

    private fun doSignup() {
        if (!validate()) {



        }else {


                uploadImage()
                val apiInterface = ApiInterface.create()


                apiInterface.register(

                    txtName.text.toString(),
                    txtEmail.text.toString(),
                    txtphone.text.toString(),
                    txtPassword.text.toString(),
                    fileName.toString(),








                ).enqueue(object :
                    Callback<User> {

                    override fun onResponse(call: Call<User>, response: Response<User>) {

                        val user = response.body()
                        Log.d("response", user.toString())
                        if (user != null) {
                            if (user.email == null) {

                                Toast.makeText(
                                    this@RegisterActivity,
                                    "email already exist",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            } else {
                                Toast.makeText(
                                    this@RegisterActivity,
                                    "user Success",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                startActivity(
                                    Intent(
                                        this@RegisterActivity,
                                        WelcomeActivity::class.java
                                    )
                                )

                            }
                        }


                        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    }

                    override fun onFailure(call: Call<User>, t: Throwable) {
                        Toast.makeText(
                            this@RegisterActivity,
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

        fun onLoginClick(View: View?) {
            startActivity(Intent(this, LoginActivity::class.java))
            overridePendingTransition(R.anim.slide_in_left, R.anim.stay)
            finish()
        }

    private fun validate(): Boolean {
        txtphone.error = null
        txtName.error = null
        txtEmail.error = null
        txtPassword.error = null

        if (txtName.text!!.isEmpty()){
            txtLayoutName.error = "Name Required *"
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText().toString()).matches()) {
            txtLayoutEmail.setError("Please enter a Valid E-Mail Address!");
            return false
        }

        if (txtphone.text!!.isEmpty()){
            txtLayoutPhone.error = "Phone Required *"
            return false
        }
        if (txtPassword.text!!.isEmpty()){
            txtLayoutPaswword.error = "Password Required *"
            return false
        }else {


            return true
        }
    }


}



