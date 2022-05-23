package com.example.pharmacie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmacie.models.medcate

class Cart : AppCompatActivity() {
    private lateinit var cartrecyclerview : RecyclerView
    private lateinit var medArrayList: ArrayList<medcate>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        cartrecyclerview = findViewById(R.id.CartRecyclerView)
        val image = findViewById<ImageView>(R.id.drugimage)
        val namedrug = findViewById<TextView>(R.id.categoryDrugName)
        val desdrug = findViewById<TextView>(R.id.productCategory)
        val prix = findViewById<TextView>(R.id.drug_price)
        val curr =findViewById<TextView>(R.id.price_currence)


        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("Description")
        val price = intent.getStringExtra("price")
        val categorie = intent.getStringExtra("categorie")
        val imageId = intent.getStringExtra("Image")


        cartrecyclerview.layoutManager = LinearLayoutManager(this)
        cartrecyclerview.setHasFixedSize(true)
        medArrayList = arrayListOf<medcate>()
        var cart= medcate("dolipran","fezfezf","125","","fiver")
        medArrayList.add(cart)
        cart= medcate("dolipran","fezfezf","125","","fiver")
        medArrayList.add(cart)
        cart= medcate("dolipran","fezfezf","125","","fiver")
        medArrayList.add(cart)

        cartrecyclerview.adapter = MydrugAdapter(medArrayList)

    }
}