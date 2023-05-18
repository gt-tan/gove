package com.gttan.gove.presentation.features.search

import androidx.lifecycle.ViewModel
import com.gttan.gove.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

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

    fun setQuery(query: String) {
        _state.update {
            it.copy(
                query = query,
            )
        }
    }

    fun selectFilter(filter: String) {
        val selectedCategories = _state.value.selectedCategories.toMutableList()

        if (selectedCategories.contains(filter)) {
            selectedCategories.remove(filter)
        } else {
            selectedCategories.add(filter)
        }

        _state.update {
            it.copy(
                selectedCategories = selectedCategories,
            )
        }
    }

    fun getFilteredList(state: SearchDataState): List<Product> {
        return state.products.let { products ->
            if (state.query.length > 2) {
                products.filter { product ->
                    product.title.contains(state.query, true)
                }
            } else {
                state.products
            }.filter { product ->
                if (state.selectedCategories.isNotEmpty()) {
                    product.category in state.selectedCategories
                } else {
                    true
                }
            }
        }
    }
}
