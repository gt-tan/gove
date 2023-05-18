package com.gttan.gove.presentation.features.product_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.gttan.gove.domain.use_cases.cart.CartUseCases
import com.gttan.gove.domain.use_cases.product.ProductUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productUseCases: ProductUseCases,
    private val cartUseCases: CartUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(ProductDetailState())
    val state get() = _state.asStateFlow()


}
