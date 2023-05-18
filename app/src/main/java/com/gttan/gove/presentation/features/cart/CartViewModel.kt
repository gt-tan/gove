package com.gttan.gove.presentation.features.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gttan.gove.domain.use_cases.cart.CartUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartUseCases: CartUseCases,
) : ViewModel() {

    private val _state = MutableStateFlow(CartDataState())
    val state get() = _state.asStateFlow()

    init {
        getCart()
    }

    private fun getCart() = viewModelScope.launch {
        cartUseCases.getCart().collect { cartItems ->
            val total = cartItems.fold(0.0) { total, value ->
                total + value.amount * value.product.price
            }
            _state.update {
                it.copy(
                    cartItems = cartItems,
                    total = total
                )
            }
        }
    }
}
