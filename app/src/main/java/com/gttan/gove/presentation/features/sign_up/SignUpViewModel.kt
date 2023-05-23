package com.gttan.gove.presentation.features.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gttan.gove.presentation.features.auth.AuthState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    private val _state = MutableStateFlow(SignUpDataState())
    val state get() = _state.asStateFlow()

    private val isRegistrationValid: String?
        get() {
            state.value.let {
                if (it.username.isBlank() || it.email.isBlank() ||
                    it.password.isBlank() || it.passwordAgain.isBlank()
                ) {
                    return "Please fill all fields"
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(it.email).matches()) {
                    return "Please enter a valid email address"
                } else if (it.password.length < 6) {
                    return "Password must be at least 6 characters"
                } else if (it.password != it.passwordAgain) {
                    return "Passwords do not match"
                }

                return null
            }
        }

    fun signUp() = viewModelScope.launch {
        state.value.let {
            isRegistrationValid?.let { errorMessage ->
                _state.update {
                    it.copy(
                        authState = AuthState.Error(errorMessage)
                    )
                }
            } ?: run {
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
                }
            }
        }
    }

    fun clear() {
        _state.update {
            it.copy(
                username = "",
                email = "",
                password = "",
                passwordAgain = ""
            )
        }
    }

    fun setFullName(fullName: String) {
        _state.update {
            it.copy(
                fullName = fullName
            )
        }
    }

    fun setUsername(username: String) {
        _state.update {
            it.copy(
                username = username
            )
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

    fun setPasswordAgain(password: String) {
        _state.update {
            it.copy(
                passwordAgain = password
            )
        }
    }

}
