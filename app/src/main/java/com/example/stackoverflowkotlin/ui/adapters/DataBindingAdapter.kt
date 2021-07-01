package com.example.stackoverflowkotlin.ui.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.stackoverflowkotlin.utils.loadImage

@BindingAdapter("imagePath")
fun ImageView.loadImagePath(imagePath: String?) {
    this.loadImage(imagePath)
}