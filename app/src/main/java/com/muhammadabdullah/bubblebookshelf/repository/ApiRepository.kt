package com.muhammadabdullah.bubblebookshelf.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.muhammadabdullah.bubblebookshelf.R
import com.muhammadabdullah.bubblebookshelf.model.BookPagesModel
import com.muhammadabdullah.bubblebookshelf.model.BooksModel
import kotlin.random.Random

class ApiRepository (){


    fun prepareBooksLiveData() : MutableLiveData<MutableList<BooksModel>>? {
        var mutableBooksList : MutableList<BooksModel> = arrayListOf()
        mutableBooksList.add(BooksModel(0, "Abc1", "Novel",  "R.mipmap.ic_launcher"))
        mutableBooksList.add(BooksModel(1, "Abc2", "Novel",  "R.mipmap.ic_launcher"))
        mutableBooksList.add(BooksModel(2, "Abc3", "Novel",  "R.mipmap.ic_launcher"))
        mutableBooksList.add(BooksModel(3, "Abc4", "Novel",  "R.mipmap.ic_launcher"))


        val liveDataBooks = MutableLiveData<MutableList<BooksModel>>()
        liveDataBooks.value = mutableBooksList

        return liveDataBooks
    }

    fun prepareBooks() : MutableList<BooksModel>? {
        var mutableBooksList : MutableList<BooksModel> = arrayListOf()
        mutableBooksList.add(BooksModel(0, "Abc1", "Novel",  "R.mipmap.ic_launcher"))
        mutableBooksList.add(BooksModel(1, "Abc2", "Novel",  "R.mipmap.ic_launcher"))
        mutableBooksList.add(BooksModel(2, "Abc3", "Novel",  "R.mipmap.ic_launcher"))
        mutableBooksList.add(BooksModel(3, "Abc4", "Novel",  "R.mipmap.ic_launcher"))

        return mutableBooksList
    }



    fun prepareBookPagesLiveData() : MutableLiveData<MutableList<BookPagesModel>>? {
        var mutableBooksList : MutableList<BookPagesModel> = arrayListOf()
        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc1-book0", "Novel", "", 0))
        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc2-book0", "Novel", "", 0))
        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc3-book0", "Novel", "", 0))
        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc4-book0", "Novel", "", 0))


        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc1-book1", "Novel", "", 1))
        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc2-book1", "Novel", "", 1))
        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc3-book1", "Novel", "", 1))
        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc4-book1", "Novel", "", 1))


        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc1-book2", "Novel", "", 2))
        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc2-book2", "Novel", "", 2))
        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc3-book2", "Novel", "", 2))
        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc4-book2", "Novel", "", 2))

        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc1-book3", "Novel", "", 3))
        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc2-book3", "Novel", "", 3))
        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc3-book3", "Novel", "", 3))
        mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc4-book3", "Novel", "", 3))
        val liveDataBooks = MutableLiveData<MutableList<BookPagesModel>>()
        liveDataBooks.value = mutableBooksList

        return liveDataBooks
    }

    fun prepareBookPages(bookId : Int) : MutableList<BookPagesModel>? {
        var mutableBooksList : MutableList<BookPagesModel> = arrayListOf()

        if (bookId == 0) {

            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc1-book0", "Novel", "", 0))
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc2-book0", "Novel", "", 0))
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc3-book0", "Novel", "", 0))
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc4-book0", "Novel", "", 0))
        }


        if (bookId == 1) {
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc1-book1", "Novel", "", 1))
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc2-book1", "Novel", "", 1))
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc3-book1", "Novel", "", 1))
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc4-book1", "Novel", "", 1))
        }

        if (bookId == 2) {
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc1-book2", "Novel", "", 2))
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc2-book2", "Novel", "", 2))
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc3-book2", "Novel", "", 2))
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc4-book2", "Novel", "", 2))
        }

        if (bookId == 3) {
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc1-book3", "Novel", "", 3))
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc2-book3", "Novel", "", 3))
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc3-book3", "Novel", "", 3))
            mutableBooksList.add(BookPagesModel(Random.nextInt(), "Abc4-book3", "Novel", "", 3))
        }
        return mutableBooksList
    }

}