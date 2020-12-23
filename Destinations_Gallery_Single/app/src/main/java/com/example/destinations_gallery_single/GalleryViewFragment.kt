package com.example.destinations_gallery_single

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.destinations_gallery_single.adapter.GalleryItemAdapter
import com.example.destinations_gallery_single.data.Datasource
import com.example.destinations_gallery_single.databinding.FragmentGalleryViewBinding


class GalleryViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentGalleryViewBinding>(
            inflater, R.layout.fragment_gallery_view, container, false
        )

        val myDataset = Datasource().loadDestinations()
        val recyclerView: RecyclerView = binding.recyclerView;
        recyclerView.adapter = this.context?.let { GalleryItemAdapter(it, myDataset) }
        recyclerView.setHasFixedSize(true)

        return binding.root
    }

}