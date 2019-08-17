package com.muhammadabdullah.bubblebookshelf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import com.muhammadabdullah.bubblebookshelf.databinding.GridItemBinding

class AlphabetAdapter(
    var resourceId: Int, var alphabetModelList: MutableList<AlphabetModel>, var alphabetViewModel: AbstractBaseViewModel
) : BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View

        p1?.let {
            return p1
        }

        view = LayoutInflater.from(p2!!.context).inflate(resourceId, null)

        val gridItemBinding: GridItemBinding? = DataBindingUtil.bind<GridItemBinding?>(view)
        gridItemBinding?.setVariable(BR.alphabet, alphabetModelList.get(p0))
        gridItemBinding?.setVariable(BR.alphabetViewModel, alphabetViewModel)

        return view

    }

    override fun getItem(p0: Int): Any {
        return alphabetModelList.get(p0)

    }

    override fun getItemId(p0: Int): Long {
        return 0

    }

    override fun getCount(): Int {
        return return alphabetModelList.size

    }

}