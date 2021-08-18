package com.akshatsahijpal.myapplication.ui.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _state : MutableLiveData<String> = MutableLiveData("")
    var state : LiveData<String> = _state
    fun mainEventHandler(newVal : String) {
        _state.value = newVal
    }
}