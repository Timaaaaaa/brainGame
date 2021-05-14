package com.start.gameapp.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.start.gameapp.presentation.base.BaseViewModel

class HomeViewModel : BaseViewModel() {

    val number = MutableLiveData<Int>()

}