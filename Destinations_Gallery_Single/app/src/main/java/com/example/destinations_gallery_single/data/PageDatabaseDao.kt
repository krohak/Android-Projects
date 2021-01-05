package com.example.destinations_gallery_single.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.destinations_gallery_single.model.Page

@Dao
interface PageDatabaseDao {

    @Insert
    fun insert(page: Page)

    @Update
    fun update(page: Page)

    @Query("SELECT * from pages_table WHERE Id = :key")
    fun get(key: Long): Page?

    @Query("DELETE FROM pages_table")
    fun clear()

    @Query("SELECT * FROM pages_table ORDER BY Id DESC")
    fun getAllPages(): LiveData<List<Page>>
}