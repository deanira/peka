package com.pakis.pinus.core.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.pakis.pinus.core.R

object Helper {
    fun ImageView.loadImage(url: String?) {
        Glide.with(this.context)
            .load(url)
            .placeholder(R.color.gray)
            .into(this)
    }
}