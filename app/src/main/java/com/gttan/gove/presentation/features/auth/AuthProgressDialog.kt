package com.gttan.gove.presentation.features.auth

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import com.gttan.gove.R

class AuthProgressDialog(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.layout_progress)

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setCancelable(false)
    }
}
