package com.gttan.gove.presentation.util

import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

infix fun ImageView.setProductImage(url: String) {
    Glide.with(this).load(url).into(this)
}

infix fun TextView.setPrice(price: Double) {
    this.text = String.format("$.2f".format(price))
}
