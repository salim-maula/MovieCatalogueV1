package com.example.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.VideoEntity
import com.example.moviecatalogue.utils.DataDummy

class DetailVideoViewModel : ViewModel() {

    private lateinit var videoId: String

    lateinit var video: VideoEntity

    fun setSelectedVideo(videoId: String) {
        this.videoId = videoId
    }

    fun getDetailVideo(): VideoEntity {
        val videoEntities = DataDummy.generateDummyMovie()
        for (videoEntity in videoEntities) {
            if (videoEntity.videoId == videoId) {
                video = videoEntity
            }
        }
        val videoEntitiesTv = DataDummy.generateDummyTvShow()
        for (videoEntity in videoEntitiesTv) {
            if (videoEntity.videoId == videoId) {
                video = videoEntity
            }
        }
        return video
    }

}