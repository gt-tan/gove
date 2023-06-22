package com.gttan.gove.presentation.features.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gttan.gove.data.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager,
) : ViewModel() {

    private val _state = MutableStateFlow(ProfileDataState())
    val state get() = _state.asStateFlow()

    init {
        getUserInfo()
    }

    private fun getUserInfo() {
        // TODO:
    }

    fun signOut() {
        viewModelScope.launch {
            dataStoreManager.setSignedIn(false)
            // TODO:
        }
    }
}
