package com.example.destinations_gallery_single.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.destinations_gallery_single.PageFragmentDirections
import com.example.destinations_gallery_single.databinding.GalleryItemBinding
import com.example.destinations_gallery_single.model.Page

class GalleryItemAdapter(private val context: Context) : ListAdapter<Page, RecyclerView.ViewHolder>(PlantDiffCallback()) {

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
                binding.page?.let { page ->
                    navigateToPage(page, it)
                }
            }
        }

        private fun navigateToPage(
            page: Page,
            view: View
        ) {
            val direction = PageFragmentDirections.actionPageFragmentSelf(page)
            view.findNavController().navigate(direction)
        }

        fun bind(pageItem: Page, context: Context, position: Int) {

            binding.apply {
                page = pageItem
                itemNumber.text = position.toString()
                itemImage.setImageResource(context.resources.getIdentifier(
                    pageItem.coverPhotoName,
                        "drawable",
                        context.packageName
                )
                )
            }
        }
    }
}

private class PlantDiffCallback : DiffUtil.ItemCallback<Page>() {

    override fun areItemsTheSame(oldItem: Page, newItem: Page): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Page, newItem: Page): Boolean {
        return oldItem == newItem
    }
}