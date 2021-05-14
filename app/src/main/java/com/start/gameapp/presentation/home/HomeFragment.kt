package com.start.gameapp.presentation.home

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.start.gameapp.R
import com.start.gameapp.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.f_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment(R.layout.f_home){

    private val homeViewModel : HomeViewModel by viewModel()

    lateinit var adapter : GameItemAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        number2
        homeViewModel.number.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()
        })


        homeViewModel.number.postValue(123)
    }
}