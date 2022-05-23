import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.pharmacie.ItemsViewModel
import com.example.pharmacie.R
import com.example.pharmacie.UserActivity
import com.example.pharmacie.models.medcate
import kotlinx.android.synthetic.main.item_drug_gridview.view.*

class CustomAdapter(val mList: MutableList<medcate>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_drug_gridview, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.itemView.apply {

            val path = "https://firebasestorage.googleapis.com/v0/b/pharmacie-cef9a.appspot.com/o/images%2F"+ItemsViewModel.photo+"?alt=media"
            Glide.with(holder.itemView.context)
                .load(path)

                .into(drug_image)
            Log.e("image",path)

            drugName.setText(ItemsViewModel.name)
            drugPrice.setText(ItemsViewModel.prix)
            drugDescription.setText(ItemsViewModel.description)
        }

        holder.itemView.setOnClickListener {
            val i = Intent (holder.itemView.context, UserActivity::class.java)
            i.putExtra("name",ItemsViewModel.name)
            i.putExtra("Description",ItemsViewModel.description)
            i.putExtra("price",ItemsViewModel.prix)
            i.putExtra("Image",ItemsViewModel.photo)
            i.putExtra("categorie",ItemsViewModel.categorie)

            holder.itemView.context.startActivity(i)
        }
        Log.e("infooo",holder.toString())
        Log.e("image rrrtrt",ItemsViewModel.photo)

        // sets the text to the textview from our itemHolder class


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)
}
