package com.example.moviecatalogue.ui.tvshows

import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.VideoEntity
import com.example.moviecatalogue.utils.DataDummy

class TvShowViewModel : ViewModel(){
    fun getVideo(): List<VideoEntity> = DataDummy.generateDummyTvShow()
}