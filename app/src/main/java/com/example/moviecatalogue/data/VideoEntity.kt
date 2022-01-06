package com.example.moviecatalogue.data

data class VideoEntity(
    var videoId : String,
    var imagePath: Int,
    var title: String,
    var description: String,
    var gendre: String,
    var year: String,
    var age: String,
    var rating: Float = 0f,
    var duration: String,
)
