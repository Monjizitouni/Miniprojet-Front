package com.example.pharmacie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowId
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pharmacie.models.LivreurCom
import com.example.pharmacie.models.Pharmacie


lateinit var id: TextView
lateinit var drugname: TextView
lateinit var Prixpdrug: TextView
lateinit var ProductDes: TextView
lateinit var quantity: TextView
class PharmacienAdapter (val mList: MutableList<Pharmacie>) : RecyclerView.Adapter<PharmacienAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacienAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pharm_items, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PharmacienAdapter.ViewHolder, position: Int) {
        id.text=mList[position].ID
        drugname.text=mList[position].drugname
        Prixpdrug.text=mList[position].Prixdrug
        ProductDes.text=mList[position].ProductDes
        quantity.text=mList[position].quantity
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView), View.OnClickListener{

        init {
            id=itemView.findViewById(R.id.productID) as TextView
            drugname=itemView.findViewById(R.id.drugname) as TextView
            Prixpdrug=itemView.findViewById(R.id.product_price) as TextView
            ProductDes=itemView.findViewById(R.id.drugdes) as TextView
            quantity=itemView.findViewById(R.id.Quantitypro) as TextView

        }

        override fun onClick(p0: View?) {
        }

    }}