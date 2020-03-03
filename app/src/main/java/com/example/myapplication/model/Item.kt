package com.example.myapplication.model

data class Item(
    val id: String,
    // used to map img_src from the JSON to imgSrcUrl in our class
    val img_src: String,
    val type: String,
    val price: Double
)