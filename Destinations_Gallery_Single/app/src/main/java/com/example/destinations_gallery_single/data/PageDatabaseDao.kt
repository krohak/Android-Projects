package com.example.destinations_gallery_single.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.destinations_gallery_single.model.Page

@Dao
interface PageDatabaseDao {

    @Insert
    fun insert(page: Page)

    @Update
    fun update(page: Page)

    @Query("SELECT * from pages_table WHERE pageId = :key")
    fun get(key: Long): LiveData<Page>

    @Query("SELECT * from pages_table WHERE parent_id = :parentId ORDER BY pageId")
    fun getChildren(parentId: Long): LiveData<List<Page>>

    @Query("DELETE FROM pages_table")
    fun clear()

    @Query("SELECT * FROM pages_table ORDER BY pageId DESC")
    fun getAllPages(): LiveData<List<Page>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<Page>)
}