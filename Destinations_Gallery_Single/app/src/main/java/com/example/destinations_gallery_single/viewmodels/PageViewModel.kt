package com.example.destinations_gallery_single.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.destinations_gallery_single.model.Page


class PageViewModel( val page: Page): ViewModel() {

    private val _galleryDataset = MutableLiveData<List<Page>>(page.tableData)
    val galleryDataset: LiveData<List<Page>>
        get() = _galleryDataset

    interface AssistedFactory {
        fun create(page: Page): PageViewModel
    }

    companion object {
        fun provideFactory(
                assistedFactory: AssistedFactory,
                page: Page
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(page) as T
            }
        }
    }

}