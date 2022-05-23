package com.example.pharmacie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton
import com.example.pharmacie.models.Medica
import com.example.pharmacie.models.medcate

lateinit var img_drug:ImageView
lateinit var name_drug:TextView
lateinit var des_drug:TextView
lateinit var prix_drug:TextView
lateinit var number_button:ElegantNumberButton
class MydrugAdapter (val mList: MutableList<medcate>) : RecyclerView.Adapter<MydrugAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MydrugAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_drug_cart, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MydrugAdapter.ViewHolder, position: Int) {
        name_drug.text=mList[position].name
        des_drug.text=mList[position].description
        prix_drug.text=mList[position].prix
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView),View.OnClickListener{

        init {
            img_drug=itemView.findViewById(R.id.drugimage) as ImageView
            name_drug=itemView.findViewById(R.id.categoryDrugName) as TextView
            des_drug=itemView.findViewById(R.id.productCategory) as TextView
            prix_drug=itemView.findViewById(R.id.drug_price) as TextView
            number_button=itemView.findViewById(R.id.Button_quantity) as ElegantNumberButton

        }

        override fun onClick(p0: View?) {
        }

    }


}