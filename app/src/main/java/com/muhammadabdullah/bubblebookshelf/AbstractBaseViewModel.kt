package com.muhammadabdullah.bubblebookshelf

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.Observer

abstract class AbstractBaseViewModel : ViewModel(){

    var singleLiveData = MutableLiveData<String>()
    open val alphabets: String = "123456789"
    open lateinit var alphabetModelList: MutableList<AlphabetModel>
    open lateinit var adapter: AlphabetAdapter

    init {
        prepareBook()

    }

    override fun onCleared() {
        super.onCleared()
    }



    open fun prepareBook() {
        alphabetModelList = arrayListOf()
        alphabets.forEach {
            var alphabetModel =
                AlphabetModel(
                    Character.toString(it),
                    Character.toString(it),
                    R.mipmap.ic_launcher,
                    Color.GREEN,
                    "books",
                    0
                )
            alphabetModelList.add(alphabetModel)
        }
        adapter = AlphabetAdapter(R.layout.grid_item, alphabetModelList, this)

    }


    open fun onItemClick (alphabetModel: AlphabetModel){

        singleLiveData.value = alphabetModel.id

    }

}