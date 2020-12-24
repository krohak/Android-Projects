package com.example.destinations_gallery_single.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.destinations_gallery_single.databinding.FragmentGalleryItemBinding
import com.example.destinations_gallery_single.model.Destination

class GalleryItemAdapter(private val context: Context, private val dataset: List<Destination>?) :
    RecyclerView.Adapter<GalleryItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val galleryItemBinding: FragmentGalleryItemBinding) :
        RecyclerView.ViewHolder(galleryItemBinding.root) {

        fun bind(destinationItem: Destination, context: Context, position: Int) {

            galleryItemBinding.destination = destinationItem

            galleryItemBinding.apply {
                itemNumber.text = position.toString()
                val resourceId = context.resources.getIdentifier(
                    destinationItem.imageName, "drawable", context.packageName
                );
                galleryItemBinding.itemImage.setImageResource(resourceId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val galleryItemBinding =
            FragmentGalleryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(galleryItemBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val destinationItem = dataset?.get(position)
        if (destinationItem != null) {
            holder.bind(destinationItem, context, position)
        }
    }

    override fun getItemCount(): Int = dataset?.size ?: 0
}