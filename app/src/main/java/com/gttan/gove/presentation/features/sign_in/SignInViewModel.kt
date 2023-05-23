package com.gttan.gove.presentation.features.sign_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gttan.gove.presentation.features.auth.AuthState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {

    private val _state = MutableStateFlow(SignInDataState())
    val state get() = _state.asStateFlow()

    fun signIn() {
        _state.update {
            it.copy(
                isLoading = true
            )
        }

        // TODO:
        viewModelScope.launch {
            delay(2000L)
            _state.update {
                it.copy(
                    authState = AuthState.Success,
                    isLoading = false
                )
            }
        }
    }

    fun setEmail(email: String) {
        _state.update {
            it.copy(
                email = email
            )
        }
    }

    fun setPassword(password: String) {
        _state.update {
            it.copy(
                password = password
            )
        }
    }
}
