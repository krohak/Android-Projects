package com.example.destinations_gallery_single.data

//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.destinations_gallery_single.model.Page
//import com.example.destinations_gallery_single.utilities.DATABASE_NAME
//
//
//@Database(entities = [Page::class], version = 1, exportSchema = false)
//abstract class PageDatabase : RoomDatabase() {
//    abstract val pageDatabaseDao: PageDatabaseDao
//
//    companion object {
//        @Volatile private var instance: PageDatabase? = null
//
//        fun getInstance(context: Context): PageDatabase {
//
//            return instance ?: synchronized(this) {
//                instance ?: Room.databaseBuilder(
//                    context.applicationContext,
//                    PageDatabase::class.java,
//                    DATABASE_NAME)
//                    .fallbackToDestructiveMigration()
//                    .build()
//            }
//
//        }
//    }
//}