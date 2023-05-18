package com.gttan.gove.presentation.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gttan.gove.data.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager,
) : ViewModel() {

    private val _viewState = MutableSharedFlow<SplashViewEvent>()
    val viewState get() = _viewState.asSharedFlow()

    init {
        viewModelScope.launch {
            dataStoreManager.getFirstTime.collect { isFirstTime ->
                if (isFirstTime) {
                    _viewState.emit(SplashViewEvent.ToOnBoardingFragment)
                } else {
                    _viewState.emit(SplashViewEvent.ToMainFragment)
                }
            }
        }
    }
}
