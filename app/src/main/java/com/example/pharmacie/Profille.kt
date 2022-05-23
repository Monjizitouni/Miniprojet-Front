package com.example.pharmacie

import CustomAdapter
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import de.hdodenhof.circleimageview.CircleImageView
import com.example.pharmacie.databinding.ActivityProfilleBinding
import com.example.pharmacie.models.*
import com.example.pharmacie.utils.Apicat
import com.example.pharmacie.utils.Apimedic
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profille.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

const val PREF_NAME = "DATA_CV_PREF"
class Profille : AppCompatActivity() {

    private lateinit var binding: ActivityProfilleBinding
    private lateinit var userArrayList: ArrayList<medcate>
    lateinit var perfermences : SharedPreferences
    private lateinit var mSharedPref: SharedPreferences

    lateinit var toggle: ActionBarDrawerToggle

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState )
        setContentView(R.layout.activity_profille)
        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        perfermences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val apiInterface = Apicat.create()
        val apiIntermed = Apimedic.create()


        val filename2 = mSharedPref.getString("avatar", "avatar")
        val usename = mSharedPref.getString("email", "email")
        val nom = mSharedPref.getString("username", "username")

        if (filename2 != null) {
            Log.e("filename2", filename2)
        }
            if (usename != null) {
                Log.e("email",usename)
            }
        if (nom != null) {
            Log.e("nom",nom)
        }



        binding= ActivityProfilleBinding.inflate(layoutInflater)
        setContentView(binding.root)





        apiIntermed.show().enqueue(object :
            Callback<MutableList<medcate>>
        {
            override fun onResponse(call: Call<MutableList<medcate>>, response: Response<MutableList<medcate>>) {

                val cat = response.body()
                Log.e("response cat : ",cat.toString())
                if(cat != null)
                {
                    val adapter = CustomAdapter(cat)
                    rv_medic.adapter = adapter

                    rv_medic.layoutManager =
                        LinearLayoutManager(this@Profille, LinearLayoutManager.VERTICAL, false)
                }

            }

            override fun onFailure(call: Call<MutableList<medcate>>, t: Throwable) {
                Toast.makeText(
                    this@Profille,
                    "Connexion error!",
                    Toast.LENGTH_SHORT
                )
                    .show()



                window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            }

        })


        val imageId= intArrayOf(

            R.drawable.med2,R.drawable.med2,R.drawable.med2,
            R.drawable.med2,R.drawable.med2,R.drawable.med2,

            )

        val name= arrayOf(
            "Panadole",
            "Doliprane",
            "picto6",
            "Asperene",
            "Panadole Extra",
            "Panadole 1g"


        )

        val des = arrayOf(
            "efhzoehfzenl","qdfhlsfhelk","ekfhzekfjezn",
            "pkqejfkjze","llhfelkfne","llhfelkfne"
        )

        val price = arrayOf(

            "125","100","50","180","15","105"
        )

        val curr = arrayOf(

            "DT","DT","DT","DT","DT","DT"

        )

        userArrayList= ArrayList()

       /* for (i in name.indices){

            val user = medcate(name[i],price[i],des[i],imageId[i],curr[i])
            userArrayList.add(user)
        }
*/
      /*  binding.listview.isClickable = true
        binding.listview.adapter =Myadapter(this,userArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val description = des[position]
            val price = price[position]
            val currency=curr[position]
            val imageId = imageId[position]

            val i = Intent (this,UserActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("Description",description)
            i.putExtra("price",price)
            i.putExtra("Currency",currency)
            i.putExtra("Image",imageId)
            startActivity(i)
}

        */


        val drawerLayout: DrawerLayout = findViewById(R.id.drawerlayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val hView: View = navView.inflateHeaderView(R.layout.nav_header)
        val imgvw: CircleImageView = hView.findViewById<View>(R.id.imguser) as CircleImageView
        val tv = hView.findViewById<View>(R.id.profemail) as TextView
        val non = hView.findViewById<View>(R.id.profilname) as TextView
        val path = "https://firebasestorage.googleapis.com/v0/b/pharmacie-cef9a.appspot.com/o/images%2F"+filename2+"?alt=media"
        Glide.with(this)
            .load(path)
            .into(imgvw)
        tv.text=usename.toString()
        non.text = nom.toString()

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)


        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)




        navView.setNavigationItemSelectedListener {


            when (it.itemId) {
                R.id.nav_home -> Toast.makeText(
                    applicationContext,
                    "Clicked Home",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_message -> Toast.makeText(
                    applicationContext,
                    "Clicked Message",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_settings -> Toast.makeText(
                    applicationContext,
                    "Clicked Settings",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_login -> {

                    mSharedPref.edit().clear().apply()

                    Toast.makeText(this, " logout success", Toast.LENGTH_SHORT).show()

                     intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.nav_share -> Toast.makeText(
                    applicationContext,
                    "Clicked share",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_rate -> Toast.makeText(
                    applicationContext,
                    "Clicked Rate",
                    Toast.LENGTH_SHORT
                ).show()


            }
            true
        }
        var mlist : MutableList<categorie>

        val list : MutableList<String> = ArrayList()
        apiInterface.show().enqueue(object :
            Callback<MutableList<categorie>>
        {
            override fun onResponse(call: Call<MutableList<categorie>>, response: Response<MutableList<categorie>>) {

                val cat = response.body()
                Log.e("response cat : ",cat.toString())
                if(cat != null)
                {
                    val adapter = CatAdapter(cat)
                    recyclerviewcat.adapter = adapter

                    recyclerviewcat.layoutManager =
                        LinearLayoutManager(this@Profille, LinearLayoutManager.HORIZONTAL, false)
                }

            }

            override fun onFailure(call: Call<MutableList<categorie>>, t: Throwable) {
                Toast.makeText(
                    this@Profille,
                    "Connexion error!",
                    Toast.LENGTH_SHORT
                )
                    .show()



                window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            }



        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            Log.e("item", item.toString())
            return true
        }
        return super.onOptionsItemSelected(item)

    }
}


