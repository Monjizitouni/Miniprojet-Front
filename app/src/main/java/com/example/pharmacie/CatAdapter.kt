package com.example.pharmacie

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pharmacie.models.categorie
import kotlinx.android.synthetic.main.card_view.view.*
import java.util.*

class CatAdapter ( var mList: MutableList<categorie>) : RecyclerView.Adapter<CatAdapter.AdapterViewHolder>(){

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)
        Log.e("aaaaaaaaaaaaaaa :","e5dem")

        return AdapterViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {

        holder.itemView.apply {
            Log.e("name",mList[position].name)

            // sets the image to the imageview from our itemHolder class
            //holder.imageView4.setImageResource(ItemsViewModel.avatar)

            // sets the text to the textview from our itemHolder class
           category.text = mList[position].name

            //holder.textView.setText("hhh")
            // mList[position].name
        }


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    inner class AdapterViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        init {
            itemView.setOnClickListener{v:View->



            val position : Int = adapterPosition
                Toast.makeText(itemView.context, "you clicked item${position+1}", Toast.LENGTH_SHORT).show()

        }
        }
    }


}