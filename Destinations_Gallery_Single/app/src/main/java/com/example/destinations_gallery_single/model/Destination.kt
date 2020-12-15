package com.example.destinations_gallery_single.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Destination(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)