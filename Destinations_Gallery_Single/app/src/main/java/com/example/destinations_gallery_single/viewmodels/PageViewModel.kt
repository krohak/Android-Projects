package com.example.destinations_gallery_single.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.destinations_gallery_single.data.PageDatabaseDao


class PageViewModel(pageId: Long, database: PageDatabaseDao, application: Application) :
    AndroidViewModel(application) {

    var galleryDataset = database.getChildren(pageId)
    var page = database.get(pageId)
}

class PageViewModelFactory(
    private val pageId: Long,
    private val database: PageDatabaseDao,
    private val application: Application
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PageViewModel::class.java)) {
            return PageViewModel(pageId, database, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}