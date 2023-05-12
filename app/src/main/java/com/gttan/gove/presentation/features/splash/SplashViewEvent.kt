package com.gttan.gove.presentation.features.splash

sealed class SplashViewEvent {
    object Loading : SplashViewEvent()
    object ToMainFragment : SplashViewEvent()
    object ToOnBoardingFragment : SplashViewEvent()
}
