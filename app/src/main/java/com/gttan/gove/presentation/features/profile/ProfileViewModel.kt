package com.gttan.gove.presentation.features.profile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel() {

    private val _state = MutableStateFlow(ProfileDataState())
    val state get() = _state.asStateFlow()

    init {
        getUserInfo()
    }

    private fun getUserInfo() {
        // TODO:
    }

    fun signOut() {
        // TODO:
    }
}
