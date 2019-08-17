package com.muhammadabdullah.bubblebookshelf.repository

import com.muhammadabdullah.bubblebookshelf.model.BookPagesModel

class BookPagesRepository (){

    var apiRepository = ApiRepository()

    fun getBookPages(bookId : Int) : MutableList<BookPagesModel>{
        return apiRepository.prepareBookPages(bookId)!!
    }

}