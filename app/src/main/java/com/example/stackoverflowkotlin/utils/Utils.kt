package com.example.stackoverflowkotlin.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import java.util.*

fun ImageView.loadImage(imagePath: String?) {
    Glide
        .with(context)
        .load(imagePath)
        .transition(DrawableTransitionOptions.withCrossFade())
        .circleCrop()
        .into(this)
}

fun convertLongToDate(creationDate: Long): String {
    val date = Date(creationDate * 1000)
    return date.toString()
}
