package com.gttan.gove.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _cartTotal = MutableStateFlow(0.0)
    val cartTotal get() = _cartTotal.asStateFlow()

    init {
        getCartTotal()
    }

    private fun getCartTotal() = viewModelScope.launch {
        _cartTotal.value = 16.0
        //todo)): 异步请求数据
    }
}
