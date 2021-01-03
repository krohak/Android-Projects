package com.example.destinations_gallery_single


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.destinations_gallery_single.adapter.GalleryItemAdapter
import com.example.destinations_gallery_single.databinding.FragmentPageBinding
import com.example.destinations_gallery_single.viewmodels.PageViewModel
import com.example.destinations_gallery_single.viewmodels.PageViewModelFactory

class PageFragment : Fragment() {

    private lateinit var pageViewModelFactory: PageViewModelFactory
    private lateinit var pageViewModel: PageViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val page = PageFragmentArgs.fromBundle(requireArguments()).page
        pageViewModelFactory = PageViewModelFactory(page)
        pageViewModel = ViewModelProvider(this, pageViewModelFactory)
                .get(PageViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentPageBinding>(
                inflater, R.layout.fragment_page,
                container, false
        ).apply {
            viewModel = pageViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        this.context?.let {
            binding.coverPhotos.coverPhoto.setImageResource(it.resources.getIdentifier(
                    page.coverPhotoName,
                    "drawable",
                    it.packageName
                )
            )
        }


        val recyclerView: RecyclerView = binding.GalleryViewFragment.recyclerView

        val adapter = this.context?.let { GalleryItemAdapter(it) }

        adapter?.let {
            recyclerView.adapter = it
            subscribeUi(it)
        }

        recyclerView.setHasFixedSize(true)

        return binding.root

    }


    private fun subscribeUi(adapter: GalleryItemAdapter) {
        pageViewModel.galleryDataset.observe(viewLifecycleOwner) { galleryDataset ->
            adapter.submitList(galleryDataset)
        }
    }


}