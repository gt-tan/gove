package com.gttan.gove.presentation.features.sign_in

import com.gttan.gove.presentation.features.auth.AuthState

data class SignInDataState(
    val isLoading: Boolean = false,
    val authState: AuthState = AuthState.None,
    val email: String = "",
    val password: String = "",
)
