package com.example.destinations_gallery_single.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.destinations_gallery_single.model.Page


class PageViewModel( val page: Page): ViewModel() {

    private val _galleryDataset = MutableLiveData<List<Page>>(page.tableData)
    val galleryDataset: LiveData<List<Page>>
        get() = _galleryDataset

}

class PageViewModelFactory(private val page: Page) : ViewModelProvider.Factory  {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        Log.i("ScoreViewModelFactory", "create")
        if (modelClass.isAssignableFrom(PageViewModel::class.java)) {
            return PageViewModel(page) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}