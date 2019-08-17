package com.muhammadabdullah.bubblebookshelf.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR

class GridViewAdapter(
    var resourceId: Int, var modelList: MutableList<Any>, var viewModel: Any
) : BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View

//        p1?.let {
//            return p1
//        }

        view = LayoutInflater.from(p2!!.context).inflate(resourceId, null)

        //val gridItemBinding: GridItemBinding? = DataBindingUtil.bind(view)
//        gridItemBinding?.setVariable(BR.alphabet, alphabetModelList.get(p0))
//        gridItemBinding?.setVariable(BR.bookPagesViewModel, bookPagesViewModel)

        val viewBinding : ViewDataBinding= DataBindingUtil.bind(view)!!
        viewBinding!!.setVariable(BR.model, modelList.get(p0))
        viewBinding!!.setVariable(BR.viewmodel, viewModel)


        return view

    }

    override fun getItem(p0: Int): Any {
        return modelList.get(p0)

    }

    override fun getItemId(p0: Int): Long {
        return 0

    }

    override fun getCount(): Int {
        return modelList.size
    }

}