package com.example.destinations_gallery_single.data

import com.example.destinations_gallery_single.R
import com.example.destinations_gallery_single.model.Destination

class Datasource {

    fun loadDestinations(): List<Destination> {

        return listOf<Destination>(
            Destination(R.string.destination1, R.drawable.image1, R.integer.price1, R.string.dates1),
            Destination(R.string.destination2, R.drawable.image2, R.integer.price2, R.string.dates2),
            Destination(R.string.destination3, R.drawable.image3, R.integer.price3, R.string.dates3),
            Destination(R.string.destination4, R.drawable.image4, R.integer.price4, R.string.dates4),
            Destination(R.string.destination5, R.drawable.image5, R.integer.price5, R.string.dates5),
            Destination(R.string.destination6, R.drawable.image6, R.integer.price6, R.string.dates6),
            Destination(R.string.destination7, R.drawable.image7, R.integer.price7, R.string.dates7),
        )
    }

}