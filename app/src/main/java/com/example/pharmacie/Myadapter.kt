package com.example.pharmacie

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.pharmacie.models.medcate

class Myadapter (private val context : Activity , private val arrayList: ArrayList<medcate>) : ArrayAdapter<medcate>
    (context,R.layout.item_drug_gridview,arrayList){

/*
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_drug_gridview, null)

        val imageView: ImageView = view.findViewById(R.id.drug_image)
        val name: TextView = view.findViewById(R.id.drugName)
        val des: TextView = view.findViewById(R.id.drugDescription)
        val price: TextView = view.findViewById(R.id.drugPrice)
        val curr: TextView = view.findViewById(R.id.currenceTextView)


        imageView.setImageResource(arrayList[position].drugImage)
        name.text = arrayList[position].name
        des.text = arrayList[position].descdrug
        price.text = arrayList[position].price
        view.setOnClickListener {
            var i = Intent(this.context, UserActivity::class.java)
            i.putExtra("name", arrayList[position].name)
            i.putExtra("Description", arrayList[position].descdrug)
            i.putExtra("price", arrayList[position].price)
            i.putExtra("image", arrayList[position].drugImage)
            this.context.startActivity(i)



        }
        return view

    }

*/

}

