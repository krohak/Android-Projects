package com.example.destinations_gallery_single

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.destinations_gallery_single.data.Datasource
import com.example.destinations_gallery_single.databinding.FragmentHomeBinding
import com.example.destinations_gallery_single.model.Page

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val myDataset = this.context?.let { Datasource(it).loadPages() }

        val homePage =
            myDataset?.let {
                Page(
                    "cover",
                    "\uD83D\uDDFF",
                    "Tung Ping Chau",
                    1700,
                    "Dec 20, 2020 12:00 PM → Dec 22, 2020 12:00 PM",
                    "This page provides a guide to building a layout with ConstraintLayout in Android Studio 3.0 or higher. " +
                            "If you\\'d like more information about the Layout Editor itself, see the Android Studio guide to Build a UI with Layout Editor.",
                    "Destinations Table",
                    it
                )
            }


            Log.i("HomeFragment",homePage.toString())


            if (homePage != null) {
                val action = HomeFragmentDirections.actionHomeFragmentToPageFragment(homePage)
                NavHostFragment.findNavController(this).navigate(action)
            }


         return DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        ).root
    }


}