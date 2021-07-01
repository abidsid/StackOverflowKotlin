package com.example.stackoverflowkotlin.ui.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.stackoverflowkotlin.R
import com.example.stackoverflowkotlin.utils.convertLongToDate
import com.example.stackoverflowkotlin.utils.loadImage
import com.google.android.material.textview.MaterialTextView

@BindingAdapter("imagePath")
fun ImageView.loadImagePath(imagePath: String?) {
    this.loadImage(imagePath)
}

@BindingAdapter(value = ["ownerName", "creationDate"])
fun MaterialTextView.setOwnerAndCreationDate(ownerName: String, creationDate: Long) {
    val date = convertLongToDate(creationDate)
    this.text = String.format(this.context.getString(R.string.owner_creation_date), ownerName, date)
}