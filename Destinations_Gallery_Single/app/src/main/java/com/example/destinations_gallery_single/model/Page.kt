package com.example.destinations_gallery_single.model

data class Page (
    val coverPhotoName: String,
    val coverEmoji: String,
    val name: String,
    val price: Int,
    val dates: String,
    val pageDescription: String,
    val tableHeading: String,
    val tableData: List<Page>
)