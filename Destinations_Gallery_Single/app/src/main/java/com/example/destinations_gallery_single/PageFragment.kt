package com.example.destinations_gallery_single


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.destinations_gallery_single.adapter.GalleryItemAdapter
import com.example.destinations_gallery_single.data.PageDatabase
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
    ): View {

        val pageId: Long = PageFragmentArgs.fromBundle(requireArguments()).pageId
        val application = requireActivity().application
        val database = PageDatabase.getInstance(application).pageDatabaseDao

        pageViewModelFactory = PageViewModelFactory(pageId, database, application)
        pageViewModel = ViewModelProvider(this, pageViewModelFactory)
            .get(PageViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentPageBinding>(
            inflater, R.layout.fragment_page,
            container, false
        ).apply {
            viewModel = pageViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        val recyclerView = binding.GalleryViewFragment.recyclerView
        val adapter = GalleryItemAdapter(requireContext())
        recyclerView.adapter = adapter
        subscribeUi(adapter)

        return binding.root
    }


    private fun subscribeUi(adapter: GalleryItemAdapter) {
        pageViewModel.galleryDataset.observe(viewLifecycleOwner) { galleryDataset ->
            adapter.submitList(galleryDataset)
        }

        pageViewModel.page.observe(viewLifecycleOwner,{
            (activity as MainActivity).setActionBarTitle(it.name)
        })
    }


}