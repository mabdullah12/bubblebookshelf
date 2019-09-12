package com.muhammadabdullah.bubblebookshelf.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.muhammadabdullah.bubblebookshelf.model.BooksModel


@Dao
interface BooksDao{

    @Query("select * from books")
    fun getAllBooks() : MutableList<BooksModel>

    @Query("select * from books")
    fun getAllBooksLive() : LiveData<MutableList<BooksModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveBook(booksModel: BooksModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveBooks(booksList : MutableList<BooksModel>)

}