package com.gttan.gove.presentation.features.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gttan.gove.domain.model.Product
import com.gttan.gove.domain.use_cases.category.CategoryUseCases
import com.gttan.gove.domain.use_cases.product.ProductUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val productUseCases: ProductUseCases,
    private val categoryUseCases: CategoryUseCases,
) : ViewModel() {

    private val _state = MutableStateFlow(SearchDataState())
    val state get() = _state.asStateFlow()

    init {
        getProducts()
        getCategories()
    }

    private fun getProducts() = viewModelScope.launch(Dispatchers.IO) {
        productUseCases.getProducts().let { result ->
            result.fold(
                onSuccess = { products ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            products = products
                        )
                    }
                },
                onFailure = { error ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = error.message
                        )
                    }
                }
            )
        }
    }

    private fun getCategories() = viewModelScope.launch(Dispatchers.IO) {
        categoryUseCases.getCategories().let { result ->
            result.fold(
                onSuccess = { categories ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            categories = categories
                        )
                    }
                },
                onFailure = { error ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = error.message
                        )
                    }
                }
            )
        }
    }

    fun setQuery(query: String) {
        _state.update {
            it.copy(
                query = query
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
