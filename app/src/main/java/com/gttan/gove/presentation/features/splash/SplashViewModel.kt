package com.gttan.gove.presentation.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val _viewState = MutableSharedFlow<SplashViewEvent>()
    val viewState get() = _viewState.asSharedFlow()

    init {
        viewModelScope.launch {
            delay(100)
            _viewState.emit(SplashViewEvent.ToMainFragment)
        }
    }
}
