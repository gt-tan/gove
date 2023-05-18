package com.gttan.gove.presentation.features.on_boarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gttan.gove.data.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {
    fun setFirstTime() = viewModelScope.launch {
        dataStoreManager.setFirstTime(false)
    }
}
