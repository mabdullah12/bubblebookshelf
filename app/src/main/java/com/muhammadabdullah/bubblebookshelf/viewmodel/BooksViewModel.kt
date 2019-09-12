package com.muhammadabdullah.bubblebookshelf.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muhammadabdullah.bubblebookshelf.R
import com.muhammadabdullah.bubblebookshelf.adapter.GridViewAdapter
import com.muhammadabdullah.bubblebookshelf.model.BooksModel
import com.muhammadabdullah.bubblebookshelf.repository.BooksRepository
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.subjects.PublishSubject
import kotlin.concurrent.thread

class BooksViewModel : ViewModel(){

    var observable = PublishSubject.create<Int>()
    var booksRepository  = BooksRepository()
    lateinit var gridViewAdapter : GridViewAdapter
    var booksList: MutableList<Any> = mutableListOf()
//    var observableMutableList : Observable<MutableList<BooksModel>> = Observable.create(
//        ObservableOnSubscribe {
//            it.onNext(booksRepository.getBooksLive())
//            it.onComplete()
//        }
//    )
    init {




    }

    fun setAdapter() {
        gridViewAdapter = GridViewAdapter(R.layout.adapter_book_grid_item,  booksList, this)
    }

    fun onGridItemClick(booksModel: BooksModel){

        observable.onNext(booksModel.bookId )


    }


}

