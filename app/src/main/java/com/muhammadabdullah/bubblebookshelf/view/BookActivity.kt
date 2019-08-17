package com.muhammadabdullah.bubblebookshelf.view

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.muhammadabdullah.bubblebookshelf.R
import com.muhammadabdullah.bubblebookshelf.databinding.ActivityBookBinding
import com.muhammadabdullah.bubblebookshelf.viewmodel.BookPagesViewModel

class BookActivity : AppCompatActivity() {
    lateinit var activityBookBinding: ActivityBookBinding
    lateinit var bookPagesViewModel: BookPagesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBookBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_book
        )



        bookPagesViewModel = ViewModelProviders.of(this)[BookPagesViewModel::class.java] //AlphabetViewModel(this)
        bookPagesViewModel.setAdapter(intent.getIntExtra("book_id", 0))
        activityBookBinding.viewmodel = bookPagesViewModel

    }


}
