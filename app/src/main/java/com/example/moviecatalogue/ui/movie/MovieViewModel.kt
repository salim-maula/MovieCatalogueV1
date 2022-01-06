package com.example.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.VideoEntity
import com.example.moviecatalogue.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getVideo(): List<VideoEntity> = DataDummy.generateDummyMovie()
}