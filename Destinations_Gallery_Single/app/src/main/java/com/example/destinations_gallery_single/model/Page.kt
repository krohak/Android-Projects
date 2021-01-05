package com.example.destinations_gallery_single.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "pages_table")
data class Page(
        @PrimaryKey(autoGenerate = true) val Id: Long = 0L,
        @ColumnInfo(name = "cover_photo_name") val coverPhotoName: String,
        @ColumnInfo(name = "cover_emoji") var coverEmoji: String,
        @ColumnInfo(name = "destination_name") var name: String,
        @ColumnInfo(name = "destination_price") var price: Int,
        @ColumnInfo(name = "destination_dates") var dates: String,
        @ColumnInfo(name = "page_description") var pageDescription: String,
        @ColumnInfo(name = "table_heading") var tableHeading: String?,
        @ColumnInfo(name = "table_data") var tableData: List<Page>?
) : Parcelable