package com.gttan.gove.presentation.features.profile

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {

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
