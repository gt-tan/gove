package com.gttan.gove.presentation.features.sign_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gttan.gove.data.local.DataStoreManager
import com.gttan.gove.presentation.features.auth.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager,
) : ViewModel() {

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
            delay(1000L)
            _state.update {
                it.copy(
                    authState = AuthState.Success,
                    isLoading = false
                )
            }
            dataStoreManager.setSignedIn(true)
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
