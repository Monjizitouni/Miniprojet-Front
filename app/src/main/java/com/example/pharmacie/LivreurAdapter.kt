package com.example.pharmacie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton
import com.example.pharmacie.models.LivreurCom

lateinit var ProductID:TextView
lateinit var Prodcutname:TextView
lateinit var Prixproduct:TextView
lateinit var ProductAdresse:TextView
lateinit var Quantity:TextView
class LivreurAdapter(val mList: MutableList<LivreurCom>) : RecyclerView.Adapter<LivreurAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivreurAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.livreur_comm, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivreurAdapter.ViewHolder, position: Int) {
        ProductID.text=mList[position].ProductID
        Prodcutname.text=mList[position].Prodcutname
        Prixproduct.text=mList[position].Prixproduct
        ProductAdresse.text=mList[position].ProductAdresse
        Quantity.text=mList[position].Quantity
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView), View.OnClickListener{

        init {
            ProductID=itemView.findViewById(R.id.productID) as TextView
            Prodcutname=itemView.findViewById(R.id.productname) as TextView
            Prixproduct=itemView.findViewById(R.id.comm_price) as TextView
            ProductAdresse=itemView.findViewById(R.id.comm_adresse) as TextView
            Quantity=itemView.findViewById(R.id.Quantity) as TextView

        }

        override fun onClick(p0: View?) {
        }

    }
}