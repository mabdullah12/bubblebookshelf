package com.muhammadabdullah.bubblebookshelf.viewmodel

import androidx.lifecycle.ViewModel
import com.muhammadabdullah.bubblebookshelf.R
import com.muhammadabdullah.bubblebookshelf.adapter.GridViewAdapter
import com.muhammadabdullah.bubblebookshelf.model.BookPagesModel
import com.muhammadabdullah.bubblebookshelf.repository.BookPagesRepository

class BookPagesViewModel : ViewModel(){

    var bookPagesRepository = BookPagesRepository()
    lateinit var gridViewAdapter: GridViewAdapter

    init {

    }


    fun setAdapter(bookId : Int){

        gridViewAdapter = GridViewAdapter(R.layout.adapter_page_grid_item, bookPagesRepository.getBookPages(bookId).toMutableList(), this)
    }

    fun  onGridItemClick(bookPagesModel: BookPagesModel){

    }
}