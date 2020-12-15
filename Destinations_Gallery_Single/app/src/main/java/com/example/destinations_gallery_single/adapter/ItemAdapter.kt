package com.example.destinations_gallery_single.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.destinations_gallery_single.R
import com.example.destinations_gallery_single.model.Destination
import org.w3c.dom.Text
import java.text.NumberFormat

class ItemAdapter(private val context: Context, private val dataset: List<Destination>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val numberView: TextView = view.findViewById(R.id.item_number)
        val priceTextView: TextView = view.findViewById(R.id.item_price)
        val datesTextView: TextView = view.findViewById(R.id.item_dates)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.titleTextView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
        holder.numberView.text = position.toString()
        val formattedPrice: Int = context.resources.getInteger(item.priceIntResourceId)
        holder.priceTextView.text = NumberFormat.getCurrencyInstance().format(formattedPrice)
        holder.datesTextView.text = context.resources.getString(item.datesStringResourceId)
    }

    override fun getItemCount() = dataset.size
}