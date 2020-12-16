package com.example.destinations_gallery_single.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.destinations_gallery_single.databinding.ListItemBinding
import com.example.destinations_gallery_single.model.Destination
import java.text.NumberFormat

class ItemAdapter(private val context: Context, private val dataset: List<Destination>) :
        RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val listItemBinding: ListItemBinding) : RecyclerView.ViewHolder(listItemBinding.root) {

        fun bind(destinationItem: Destination, context: Context, position: Int) {
            listItemBinding.itemTitle.text = context.resources.getString(destinationItem.stringResourceId)
            listItemBinding.itemImage.setImageResource(destinationItem.imageResourceId)
            listItemBinding.itemNumber.text = position.toString()
            val formattedPrice: Int = context.resources.getInteger(destinationItem.priceIntResourceId)
            listItemBinding.itemPrice.text = NumberFormat.getCurrencyInstance().format(formattedPrice)
            listItemBinding.itemDates.text = context.resources.getString(destinationItem.datesStringResourceId)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val listItemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val destinationItem = dataset[position]
        holder.bind(destinationItem, context, position)
    }

    override fun getItemCount() = dataset.size
}