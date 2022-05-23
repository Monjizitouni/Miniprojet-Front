package com.example.pharmacie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmacie.models.LivreurCom
import com.example.pharmacie.models.medcate


private lateinit var livreurrecyclerview : RecyclerView
private lateinit var livArrayList: ArrayList<LivreurCom>

class Livreur : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livreur)

        livreurrecyclerview = findViewById(R.id.livrecyclerview)
        val Productid = findViewById<TextView>(R.id.productID)
        val prodcutname = findViewById<TextView>(R.id.productname)
        val prixproduct = findViewById<TextView>(R.id.comm_price)
        val productadresse = findViewById<TextView>(R.id.comm_adresse)
        val quantity =findViewById<TextView>(R.id.Quantity)


        val ProductID = intent.getStringExtra("ProductID")
        val Prodcutname = intent.getStringExtra("Prodcutname")
        val Prixproduct = intent.getStringExtra("Prixproduct")
        val ProductAdresse = intent.getStringExtra("ProductAdresse")
        val Quantity = intent.getStringExtra("Quantity")


        livreurrecyclerview.layoutManager = LinearLayoutManager(this)
        livreurrecyclerview.setHasFixedSize(true)
        livArrayList = arrayListOf<LivreurCom>()
        var liv= LivreurCom("2154A","aadazd","125","ariana","2")
        livArrayList.add(liv)
        liv= LivreurCom("258A","qscm","125","manouba","6")
        livArrayList.add(liv)
        liv= LivreurCom("2648A","meafk","125","soussa","7")
        livArrayList.add(liv)

        livreurrecyclerview.adapter = LivreurAdapter(livArrayList)


    }
}