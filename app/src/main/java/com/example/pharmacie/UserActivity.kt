package com.example.pharmacie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pharmacie.models.Pharmdata
import kotlinx.android.synthetic.main.activity_drug_details.*
import kotlinx.android.synthetic.main.item_drug_gridview.view.*

class UserActivity : AppCompatActivity() {

    private lateinit var nrecyclerview : RecyclerView
    private lateinit var pharArrayList: ArrayList<Pharmdata>
    lateinit var image1 : Array<Int>
    lateinit var nameph : Array<String>
    lateinit var nameloc : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drug_details)


       val image = findViewById<ImageView>(R.id.drugCoverImageView)
        val namedrug = findViewById<TextView>(R.id.drugNameTextView)
        val desdrug = findViewById<TextView>(R.id.drugDescriptionTextView)
        val prix = findViewById<TextView>(R.id.drugUnitPriceTextView)
        val curr =findViewById<TextView>(R.id.categoryTextView)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("Description")
        val price = intent.getStringExtra("price")
        val categorie = intent.getStringExtra("categorie")
        val imageId = intent.getStringExtra("Image")
        val path = "https://firebasestorage.googleapis.com/v0/b/pharmacie-cef9a.appspot.com/o/images%2F"+imageId+"?alt=media"
        Glide.with(this)
            .load(path)

            .into(image)
        Log.e("/////////////image",path)
        namedrug.text=name
        desdrug.text=description
        prix.text=price
        curr.text=categorie

        image1 = arrayOf(

            R.drawable.btn4,
            R.drawable.btn4

        )

        nameph = arrayOf(
            "Pharmacie Louay",
            "Pharmacie Monji",
            "Pharmacie Louay",
            "Pharmacie Monji",
            "Pharmacie Louay",
            "Pharmacie Monji"

            )
        nameloc = arrayOf(
            "Ariana",
            "Manouba",
            "Ariana",
            "Manouba",
            "Ariana",
            "Manouba"


            )
        nrecyclerview = findViewById(R.id.pharmdetails)
        nrecyclerview.layoutManager = LinearLayoutManager(this)
        nrecyclerview.setHasFixedSize(true)
        pharArrayList = arrayListOf<Pharmdata>()
        var pharmm= Pharmdata(5,nameph[0],nameloc[0])
        pharArrayList.add(pharmm)
        pharmm= Pharmdata(6,nameph[1],nameloc[1])
        pharArrayList.add(pharmm)
         pharmm= Pharmdata(7,nameph[2],nameloc[2])
        pharArrayList.add(pharmm)
        pharmm= Pharmdata(7,nameph[3],nameloc[1])
        pharArrayList.add(pharmm)
        pharmm= Pharmdata(7,nameph[4],nameloc[1])
        pharArrayList.add(pharmm)
        pharmm= Pharmdata(7,nameph[4],nameloc[1])
        pharArrayList.add(pharmm)



    nrecyclerview.adapter = PharmAdapter(pharArrayList)
        cartbutton.setOnClickListener{intent = Intent(this, Cart::class.java)
            startActivity(intent)
            finish()}
        addtopanier.setOnClickListener{

            Toast.makeText(this, " Your product is add to your cart", Toast.LENGTH_SHORT).show()
        }

    }
}
