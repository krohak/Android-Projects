package com.example.destinations_gallery_single.data

import android.content.Context
import com.example.destinations_gallery_single.model.Page
import com.example.destinations_gallery_single.utilities.DESTINATIONS_DATA_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader

class Datasource(private val applicationContext: Context) {

    fun loadPages(): List<Page> {

        applicationContext.assets.open(DESTINATIONS_DATA_FILENAME).use { inputStream ->
            JsonReader(inputStream.reader()).use { jsonReader ->
                val destinationType = object : TypeToken<List<Page>>() {}.type
                return Gson().fromJson(jsonReader, destinationType)
            }
        }
    }

}