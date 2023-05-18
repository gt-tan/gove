package com.gttan.gove.presentation.features.products

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductsViewModel : ViewModel() {

    private val _state = MutableStateFlow(ProductsDataState())
    val state get() = _state.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts() {
        // TODO: 请求products数据
    }
}
