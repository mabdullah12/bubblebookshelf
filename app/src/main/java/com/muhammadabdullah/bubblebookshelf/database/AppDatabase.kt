package com.muhammadabdullah.bubblebookshelf.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.muhammadabdullah.bubblebookshelf.model.BooksModel

@Database(entities = arrayOf(BooksModel::class), version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun booksDao() : BooksDao

    companion object{
        @Volatile
        private var instance : AppDatabase?= null

        fun getDatabase(context: Context) : AppDatabase{
            if (instance == null){
                synchronized(this){
                    instance = Room.databaseBuilder(context,
                        AppDatabase::class.java, "bubble_book_shelf").build()
                }
            }
            return instance!!
        }
    }

}