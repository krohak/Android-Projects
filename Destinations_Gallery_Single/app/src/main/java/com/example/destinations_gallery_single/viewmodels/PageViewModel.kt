package com.example.destinations_gallery_single.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.destinations_gallery_single.model.Destination

class PageViewModel: ViewModel() {

    val galleryDataset = MutableLiveData<List<Destination>>()

}