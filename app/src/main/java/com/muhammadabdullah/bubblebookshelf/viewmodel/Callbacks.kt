package com.muhammadabdullah.bubblebookshelf.viewmodel

import com.muhammadabdullah.bubblebookshelf.model.BooksModel

interface Callbacks {

    fun dynamoCallback(mutableList: MutableList<BooksModel>)
}