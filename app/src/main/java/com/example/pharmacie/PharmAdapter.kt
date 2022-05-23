package com.example.pharmacie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pharmacie.models.Pharmdata
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.android.synthetic.main.item_drug_gridview.view.*

class PharmAdapter(private val pharmlist : ArrayList<Pharmdata>):
    RecyclerView.Adapter<PharmAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_pharm,
            parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem = pharmlist[position]
        val path = "https://firebasestorage.googleapis.com/v0/b/pharmacie-cef9a.appspot.com/o/images%2F"+"2021_11_30_20_04_28"+"?alt=media"
        Glide.with(holder.itemView.context)
            .load(path)

            .into(holder.pic_pharm)
        holder.namepharm.text = currentItem.pharmname
        holder.locationpharm.text = currentItem.pharmlocation



    }

    override fun getItemCount(): Int {
      return pharmlist.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

      val pic_pharm : ImageView = itemView.findViewById(R.id.pharmpic)
        val namepharm : TextView = itemView.findViewById(R.id.pharmename)
        val locationpharm : TextView = itemView.findViewById(R.id.pharmlocation)
        val info : ImageView = itemView.findViewById(R.id.info)
       val messagerie : ImageView = itemView.findViewById(R.id.chat)


    }


}