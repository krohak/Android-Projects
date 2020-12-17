package com.example.destinations_gallery_single.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.NumberFormat

@BindingAdapter("imageResource")
fun setImageResource(imageView: ImageView, imageResourceId: Int) {
    imageView.setImageResource(imageResourceId)
}

@BindingAdapter("formattedPrice")
fun setFormattedPrice(textView: TextView, price: Int) {
    textView.text = NumberFormat.getCurrencyInstance().format(price)
}
