package com.gttan.gove

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GoveApp : Application()
// {
//     companion object {
//         lateinit var appContext: Context
//     }
//
//     override fun onCreate() {
//         super.onCreate()
//         appContext = applicationContext
//     }
// }
