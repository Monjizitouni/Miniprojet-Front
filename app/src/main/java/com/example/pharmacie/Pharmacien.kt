package com.example.pharmacie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmacie.models.LivreurCom
import com.example.pharmacie.models.Pharmacie


private lateinit var pharmrecyclerview : RecyclerView
private lateinit var pharmArrayList: ArrayList<Pharmacie>

class Pharmacien : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pharmacien)


        pharmrecyclerview = findViewById(R.id.pharmrecyclerview)
        val Productid = findViewById<TextView>(R.id.productID)
        val prodcutname = findViewById<TextView>(R.id.drugname)
        val prixproduct = findViewById<TextView>(R.id.product_price)
        val productdes = findViewById<TextView>(R.id.drugdes)
        val quantity =findViewById<TextView>(R.id.Quantitypro)


        val ProductID = intent.getStringExtra("ID")
        val Prodcutname = intent.getStringExtra("drugname")
        val Prixproduct = intent.getStringExtra("Prixdrug")
        val Productdes = intent.getStringExtra("ProductDes")
        val Quantity = intent.getStringExtra("quantity")


        pharmrecyclerview.layoutManager = LinearLayoutManager(this)
        pharmrecyclerview.setHasFixedSize(true)
        pharmArrayList = arrayListOf<Pharmacie>()
        var pharm= Pharmacie("2154A","aadazd","125","kaef,pe","2")
        pharmArrayList.add(pharm)
        pharm= Pharmacie("258A","qscm","125","apkefa","6")
        pharmArrayList.add(pharm)
        pharm= Pharmacie("2648A","meafk","125","pafaef","7")
        pharmArrayList.add(pharm)

        pharmrecyclerview.adapter = PharmacienAdapter(pharmArrayList)


    }

}
