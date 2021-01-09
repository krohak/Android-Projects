package com.example.destinations_gallery_single.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pages_table")
data class Page(
        @PrimaryKey val pageId: Long = 0L,
        @ColumnInfo(name = "parent_id") val parentId: Long = -1L,
        @ColumnInfo(name = "cover_photo_name") val coverPhotoName: String,
        @ColumnInfo(name = "cover_emoji") var coverEmoji: String,
        @ColumnInfo(name = "destination_name") var name: String,
        @ColumnInfo(name = "destination_price") var price: Int,
        @ColumnInfo(name = "destination_dates") var dates: String,
        @ColumnInfo(name = "page_description") var pageDescription: String,
        @ColumnInfo(name = "table_heading") var tableHeading: String?,
)