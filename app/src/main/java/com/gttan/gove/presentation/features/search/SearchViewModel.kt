package com.gttan.gove.presentation.features.search

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel : ViewModel() {

    private val _state = MutableStateFlow(SearchDataState())
    val state get() = _state.asStateFlow()
    init {
        getProducts()
        getCategories()
    }

    private fun getProducts() {
        // TODO:
    }

    private fun getCategories() {
        // TODO:
    }
}
