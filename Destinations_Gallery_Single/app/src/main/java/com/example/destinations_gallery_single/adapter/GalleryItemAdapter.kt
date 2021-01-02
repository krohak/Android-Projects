package com.example.destinations_gallery_single.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.destinations_gallery_single.PageFragmentDirections
import com.example.destinations_gallery_single.databinding.GalleryItemBinding
import com.example.destinations_gallery_single.model.Destination

class GalleryItemAdapter(private val context: Context) : ListAdapter<Destination, RecyclerView.ViewHolder>(PlantDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        return ItemViewHolder(GalleryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val destination = getItem(position)
        (holder as ItemViewHolder).bind(destination, context, position)
    }

    class ItemViewHolder(private val binding: GalleryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                it.findNavController().navigate(PageFragmentDirections.actionPageFragmentSelf())
            }
        }

        fun bind(destinationItem: Destination, context: Context, position: Int) {

            binding.apply {
                destination = destinationItem
                itemNumber.text = position.toString()
                binding.itemImage.setImageResource(context.resources.getIdentifier(
                        destinationItem.imageName,
                        "drawable",
                        context.packageName
                )
                )
            }
        }
    }
}

private class PlantDiffCallback : DiffUtil.ItemCallback<Destination>() {

    override fun areItemsTheSame(oldItem: Destination, newItem: Destination): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Destination, newItem: Destination): Boolean {
        return oldItem == newItem
    }
}