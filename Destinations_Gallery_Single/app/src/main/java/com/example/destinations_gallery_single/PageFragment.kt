package com.example.destinations_gallery_single


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.destinations_gallery_single.adapter.GalleryItemAdapter
import com.example.destinations_gallery_single.databinding.FragmentPageBinding
import com.example.destinations_gallery_single.viewmodels.PageViewModel

class PageFragment : Fragment() {

    private val args: PageFragmentArgs by navArgs()

    lateinit var pageViewModelFactory: PageViewModel.AssistedFactory
    private val viewModel: PageViewModel by viewModels {
        PageViewModel.provideFactory(
            pageViewModelFactory,
            args.page
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentPageBinding>(
            inflater,
            R.layout.fragment_page,
            container,
            false
        ).apply {
            viewModel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }


        val recyclerView: RecyclerView = binding.GalleryViewFragment.recyclerView

        val adapter = this.context?.let { GalleryItemAdapter(it) }

        recyclerView.adapter = adapter
        adapter?.let { subscribeUi(it) }

        recyclerView.setHasFixedSize(true)

        return binding.root

    }


    private fun subscribeUi(adapter: GalleryItemAdapter) {
        viewModel.galleryDataset.observe(viewLifecycleOwner) { galleryDataset ->
            adapter.submitList(galleryDataset)
        }
    }


}