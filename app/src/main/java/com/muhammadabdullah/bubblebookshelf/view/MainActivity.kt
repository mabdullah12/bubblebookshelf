package com.muhammadabdullah.bubblebookshelf.view

import android.annotation.TargetApi
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.amazonaws.mobile.client.AWSMobileClient
import com.muhammadabdullah.bubblebookshelf.R
import com.muhammadabdullah.bubblebookshelf.databinding.ActivityMainBinding
import com.muhammadabdullah.bubblebookshelf.model.BooksModel
import com.muhammadabdullah.bubblebookshelf.viewmodel.BooksViewModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity(){


    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var booksViewModel: BooksViewModel
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )



        booksViewModel = ViewModelProviders.of(this)[BooksViewModel::class.java]
        booksViewModel.setAdapter()
        activityMainBinding.viewmodel = booksViewModel


        booksViewModel.observable.subscribe {
            var intent = Intent(this, BookActivity::class.java)
            intent.putExtra("book_id", it)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        booksViewModel.booksRepository.getAllBooksLive().observe(this, Observer {
            booksViewModel.booksList.clear()
                 booksViewModel.booksList.addAll(it)
                 booksViewModel.gridViewAdapter.notifyDataSetChanged()
        })

//        booksViewModel.observableMutableList.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread()).subscribe(
//
//         object  : io.reactivex.Observer<MutableList<BooksModel>>{
//             override fun onSubscribe(d: Disposable) {
//                 Log.d("RX","on Subcribe")
//             }
//
//             override fun onComplete() {
//                 Log.d("RX","on Complete")
//             }
//
//             override fun onNext(t: MutableList<BooksModel>) {
//                 booksViewModel.booksList.clear()
//                 booksViewModel.booksList.addAll(t)
//                 booksViewModel.gridViewAdapter.notifyDataSetChanged()
//             }
//
//             override fun onError(e: Throwable) {
//                 Log.d("RX",e.message)
//             }
//
//
//         })

    }



}
