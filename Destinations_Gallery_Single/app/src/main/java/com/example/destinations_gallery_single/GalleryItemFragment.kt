package com.example.destinations_gallery_single

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.destinations_gallery_single.databinding.FragmentGalleryItemBinding


class GalleryItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGalleryItemBinding>(
            inflater, R.layout.fragment_gallery_item, container, false
        )
        return binding.root
    }

}