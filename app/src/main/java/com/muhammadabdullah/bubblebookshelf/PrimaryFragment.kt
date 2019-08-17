package com.muhammadabdullah.bubblebookshelf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.muhammadabdullah.bubblebookshelf.databinding.FragmentMainBinding
import com.muhammadabdullah.bubblebookshelf.viewmodel.AlphabetViewModel

class PrimaryFragment : Fragment(){
    lateinit var alphabetViewModel : AlphabetViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        //val view : View = inflater.inflate(R.layout.fragment_main, container)
        val fragmentMainBinding = DataBindingUtil.inflate<FragmentMainBinding>(inflater, R.layout.fragment_main, container, false)
        fragmentMainBinding!!.vm = alphabetViewModel

        return fragmentMainBinding!!.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        alphabetViewModel  = ViewModelProviders.of(this.activity!!)[AlphabetViewModel::class.java]
        alphabetViewModel.prepareBook1(alphabetViewModel.singleLiveData.value!!)

        super.onCreate(savedInstanceState)
    }


    override fun onResume() {



        super.onResume()
    }
}