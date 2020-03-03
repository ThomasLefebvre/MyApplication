package com.example.myapplication

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("double")
fun TextView.setDoubleToString(double:Double){
    text=double.toString()
}

@BindingAdapter("imageUrl", "error")
fun loadImage(view: ImageView, imageUrl: String?, error: Drawable) {
    val uri=imageUrl!!.toUri().buildUpon().scheme("https").build()
    Picasso.get().load(uri).error(error).into(view)
    Log.d("URI",uri.toString())
}
