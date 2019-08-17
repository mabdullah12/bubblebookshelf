package com.muhammadabdullah.bubblebookshelf.viewmodel

import android.graphics.Color
import com.muhammadabdullah.bubblebookshelf.AbstractBaseViewModel
import com.muhammadabdullah.bubblebookshelf.AlphabetAdapter
import com.muhammadabdullah.bubblebookshelf.AlphabetModel
import com.muhammadabdullah.bubblebookshelf.R


class AlphabetViewModel() : AbstractBaseViewModel() {

   // val observer : Single<Int> = Observable.create<Int> {  }
    val alphabets1: String = "abcdefghijklmnopqrstuvwxyz"
     lateinit var alphabetModelList1: MutableList<AlphabetModel>
     lateinit var adapter1: AlphabetAdapter

    override fun onCleared() {
        super.onCleared()
    }

    init {
        System.out.println("Creating VM")
    }


     fun prepareBook1(bookValue: String) {


        alphabetModelList1 = arrayListOf()
        alphabets1.forEach {
            var alphabetModel =
                AlphabetModel(
                    Character.toString(it),
                    Character.toString(it),
                    R.mipmap.ic_launcher,
                    Color.GREEN,
                    "",
                    0
                )
            alphabetModelList1.add(alphabetModel)
        }
        adapter1 = AlphabetAdapter(
            R.layout.grid_item,
            alphabetModelList1,
            this
        )

    }

    override fun onItemClick(alphabetModel: AlphabetModel) {

        if (alphabetModel.type.equals("books")){
            singleLiveData.value = alphabetModel.id
        }
    }

}
