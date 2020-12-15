package com.example.destinations_gallery_single.data

import com.example.destinations_gallery_single.R
import com.example.destinations_gallery_single.model.Destination

class Datasource {

    fun loadDestinations(): List<Destination> {

        return listOf<Destination>(
            Destination(R.string.destination1, R.drawable.image1),
            Destination(R.string.destination2, R.drawable.image2),
            Destination(R.string.destination3, R.drawable.image3),
            Destination(R.string.destination4, R.drawable.image4),
            Destination(R.string.destination5, R.drawable.image5),
            Destination(R.string.destination6, R.drawable.image6),
            Destination(R.string.destination7, R.drawable.image7),
        )
    }

}